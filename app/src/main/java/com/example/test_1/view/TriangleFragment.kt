package com.example.test_1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demo_test.view.TriangleView
import com.example.demo_test.viewmodel.TriangleViewModel
import com.example.test_1.R

class TriangleFragment : Fragment() {

    private lateinit var viewModel: TriangleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_ex_4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Khởi tạo ViewModel
        viewModel = ViewModelProvider(this).get(TriangleViewModel::class.java)

        // Thiết lập TriangleView và TextView trong layout
        val triangleView = view.findViewById<TriangleView>(R.id.triangleView)
        val answerTextView = view.findViewById<TextView>(R.id.answer2)

        // Thiết lập ViewModel cho TriangleView và TextView
        triangleView.setViewModel(viewModel, answerTextView)

        view.findViewById<Button>(R.id.resetButton).setOnClickListener {
            viewModel.resetTriangle() // Gọi hàm reset trong ViewModel
        }
    }
}
