package com.example.test_1.Example1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.test_1.R

class ExampleFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_ex_2, container, false)

        val doneButton: Button = view.findViewById(R.id.done_btn2)
        doneButton.setOnClickListener { checkPointInTriangle() }

        return view
    }

    private fun checkPointInTriangle() {
        val ax = view?.findViewById<EditText>(R.id.Ax)?.text.toString().toDouble()
        val ay = view?.findViewById<EditText>(R.id.Ay)?.text.toString().toDouble()
        val bx = view?.findViewById<EditText>(R.id.Bx)?.text.toString().toDouble()
        val by = view?.findViewById<EditText>(R.id.By)?.text.toString().toDouble()
        val cx = view?.findViewById<EditText>(R.id.Cx)?.text.toString().toDouble()
        val cy = view?.findViewById<EditText>(R.id.Cy)?.text.toString().toDouble()
        val dx = view?.findViewById<EditText>(R.id.Dx)?.text.toString().toDouble()
        val dy = view?.findViewById<EditText>(R.id.Dy)?.text.toString().toDouble()

        val isInside = isPointInTriangle(ax, ay, bx, by, cx, cy, dx, dy)
        val answerTextView: TextView? = view?.findViewById(R.id.answer)
        answerTextView?.text = if (isInside) "Điểm A nằm trong tam giác đã cho" else "Điểm A không nằm trong tam giác đã cho"
    }

    private fun isPointInTriangle(ax: Double, ay: Double, bx: Double, by: Double, cx: Double, cy: Double, dx: Double, dy: Double): Boolean {
        val area = triangleArea(bx, by, cx, cy, dx, dy)
        val area1 = triangleArea(ax, ay, bx, by, cx, cy)
        val area2 = triangleArea(ax, ay, cx, cy, dx, dy)
        val area3 = triangleArea(ax, ay, bx, by, dx, dy)

        return area == area1 + area2 + area3
    }

    private fun triangleArea(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double): Double {
        return Math.abs((x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2)) / 2.0)
    }
}
