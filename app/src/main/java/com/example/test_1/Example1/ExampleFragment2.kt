package com.example.test_1.Example1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        val axText = view?.findViewById<EditText>(R.id.Ax)?.text.toString()
        val ayText = view?.findViewById<EditText>(R.id.Ay)?.text.toString()
        val bxText = view?.findViewById<EditText>(R.id.Bx)?.text.toString()
        val byText = view?.findViewById<EditText>(R.id.By)?.text.toString()
        val cxText = view?.findViewById<EditText>(R.id.Cx)?.text.toString()
        val cyText = view?.findViewById<EditText>(R.id.Cy)?.text.toString()
        val dxText = view?.findViewById<EditText>(R.id.Dx)?.text.toString()
        val dyText = view?.findViewById<EditText>(R.id.Dy)?.text.toString()

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
