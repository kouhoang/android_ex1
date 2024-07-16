package com.example.test_1.ui.example2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.test_1.R
import com.example.test_1.model.Triangle

class ExampleFragment2 : Fragment() {

    private lateinit var viewModel: ExampleViewModel2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_ex_2, container, false)

        viewModel = ViewModelProvider(this).get(ExampleViewModel2::class.java)

        val doneButton: Button = view.findViewById(R.id.done_btn2)
        doneButton.setOnClickListener { checkPointInTriangle() }

        return view
    }


    private fun checkPointInTriangle() {
        val axText = view?.findViewById<EditText>(R.id.Ax)?.text.toString()
        val ayText = view?.findViewById<EditText>(R.id.Ay)?.text.toString()
        val bxText = view?.findViewById<EditText>(R.id.Bx)?.text.toString()
        val byText = view?.findViewById<EditText>(R.id.By)?.text.toString()
        val cxText = view?.findViewById<EditText>(R.id.Cx)?.text.toString()
        val cyText = view?.findViewById<EditText>(R.id.Cy)?.text.toString()
        val dxText = view?.findViewById<EditText>(R.id.Dx)?.text.toString()
        val dyText = view?.findViewById<EditText>(R.id.Dy)?.text.toString()

        // Kiểm tra các tọa độ đã nhập có sót hay không.
        if (axText.isEmpty() || ayText.isEmpty() ||
            bxText.isEmpty() || byText.isEmpty() ||
            cxText.isEmpty() || cyText.isEmpty() ||
            dxText.isEmpty() || dyText.isEmpty()) {
            Toast.makeText(context, "Vui lòng nhập đầy đủ tọa độ các điểm.", Toast.LENGTH_SHORT).show()
            return
        }

        val ax = axText.toDouble()
        val ay = ayText.toDouble()
        val bx = bxText.toDouble()
        val by = byText.toDouble()
        val cx = cxText.toDouble()
        val cy = cyText.toDouble()
        val dx = dxText.toDouble()
        val dy = dyText.toDouble()

        viewModel.setTriangle(ax, ay, bx, by, cx, cy)
        viewModel.checkPointInTriangle(dx, dy)

        viewModel.isPointInsideTriangle.observe(viewLifecycleOwner, Observer { isInside ->
            val answerTextView: TextView? = view?.findViewById(R.id.answer)
            answerTextView?.text = if (isInside) "Điểm A nằm trong tam giác đã cho" else "Điểm A không nằm trong tam giác đã cho"
        })
    }
}
