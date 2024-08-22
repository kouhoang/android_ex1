package com.example.test_1.checkpointtriangle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.test_1.R

class TriangleFragment : Fragment() {

    private lateinit var viewModel: CheckPointTriangleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(CheckPointTriangleViewModel::class.java)

        // Set up TriangleView and TextView in layout
        val triangleView = view.findViewById<TriangleView>(R.id.triangleView)
        val answerTextView = view.findViewById<TextView>(R.id.answer2)

        // Set ViewModel for TriangleView and TextView
        triangleView.setViewModel(viewModel, answerTextView)

        view.findViewById<Button>(R.id.resetButton).setOnClickListener {
            viewModel.resetTriangle()
        }
    }
}
