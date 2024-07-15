package com.example.test_1.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_1.R
import com.example.test_1.adapter.HistoryAdapter
import com.example.test_1.viewmodel.ExampleViewModel
import java.io.IOException

class ExampleFragment3 : Fragment() {

    private lateinit var viewModel: ExampleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_ex_3, container, false)

        viewModel = ViewModelProvider(this).get(ExampleViewModel::class.java)

        // Debug không tìm thấy file
        try {
            // Đọc nội dung từ file profile.json trong thư mục assets
            val jsonString = requireContext().assets.open("profile.json").bufferedReader().use {
                it.readText()
            }
            viewModel.loadProfileData(jsonString)
        } catch (e: IOException) {
            e.printStackTrace()
            println("File profile.json không tìm thấy")
        }

        viewModel.profileData.observe(viewLifecycleOwner, Observer { profile ->
            // Dùng Handler để trì hoãn hiển thị dữ liệu sau 2 giây
            Handler(Looper.getMainLooper()).postDelayed({
                view?.findViewById<TextView>(R.id.name)?.text = profile.full_name
                view?.findViewById<TextView>(R.id.role)?.text = profile.position

                // Set up RecyclerView từ HistoryAdapter
                val recyclerView = view?.findViewById<RecyclerView>(R.id.historyRecyclerView)
                recyclerView?.layoutManager = LinearLayoutManager(context)
                recyclerView?.adapter = HistoryAdapter(profile.history)

                // Hiển thị dữ liệu và ẩn ProgressBar
                view?.findViewById<View>(R.id.progressBar)?.visibility = View.GONE
                view?.findViewById<TextView>(R.id.name)?.visibility = View.VISIBLE
                view?.findViewById<TextView>(R.id.role)?.visibility = View.VISIBLE
                view?.findViewById<RecyclerView>(R.id.historyRecyclerView)?.visibility = View.VISIBLE
            }, 2000)
        })

        return view
    }
}
