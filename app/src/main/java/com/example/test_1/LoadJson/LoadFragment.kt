package com.example.test_1.LoadJson

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
import com.example.test_1.LoadJson.adapter.HistoryAdapter
import java.io.IOException

class LoadFragment : Fragment() {

    private lateinit var viewModel: LoadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment3, container, false)

        viewModel = ViewModelProvider(this).get(LoadViewModel::class.java)

        // Debug cannot find file
        try {
            // Read content from profile.json file in assets folder
            val jsonString = requireContext().assets.open("profile.json").bufferedReader().use {
                it.readText()
            }
            viewModel.loadProfileData(jsonString)
        } catch (e: IOException) {
            e.printStackTrace()
            println("File profile.json không tìm thấy")
        }

        viewModel.profileData.observe(viewLifecycleOwner, Observer { profile ->
            // Use Handler to delay displaying data after 2 seconds
            Handler(Looper.getMainLooper()).postDelayed({
                view?.findViewById<TextView>(R.id.name)?.text = profile.full_name
                view?.findViewById<TextView>(R.id.role)?.text = profile.position

                // Set up RecyclerView từ HistoryAdapter
                val recyclerView = view?.findViewById<RecyclerView>(R.id.historyRecyclerView)
                recyclerView?.layoutManager = LinearLayoutManager(context)
                recyclerView?.adapter = HistoryAdapter(profile.history)

                // Show data and hide ProgressBar
                view?.findViewById<View>(R.id.progressBar)?.visibility = View.GONE
                view?.findViewById<TextView>(R.id.name)?.visibility = View.VISIBLE
                view?.findViewById<TextView>(R.id.role)?.visibility = View.VISIBLE
                view?.findViewById<RecyclerView>(R.id.historyRecyclerView)?.visibility = View.VISIBLE
            }, 2000)
        })

        return view
    }
}
