package com.example.test_1.ui.example2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_1.checktriangle.Triangle

class ExampleViewModel2 : ViewModel() {

    // LiveData to store information about the triangle.
    private val _triangle = MutableLiveData<Triangle>()
    val triangle: LiveData<Triangle>
        get() = _triangle

    // LiveData to store the results of checking whether the point is inside the triangle or not.
    private val _isPointInsideTriangle = MutableLiveData<Boolean>()
    val isPointInsideTriangle: LiveData<Boolean>
        get() = _isPointInsideTriangle

    fun setTriangle(ax: Double, ay: Double, bx: Double, by: Double, cx: Double, cy: Double) {
        _triangle.value = Triangle(ax, ay, bx, by, cx, cy)
    }

    // Check if the point is inside the triangle
    fun checkPointInTriangle(dx: Double, dy: Double) {
        val triangle = _triangle.value ?: return

        // Calculate the area of ​​the triangle
        val area = triangleArea(triangle.bx, triangle.by, triangle.cx, triangle.cy, dx, dy)
        val area1 = triangleArea(triangle.ax, triangle.ay, triangle.bx, triangle.by, triangle.cx, triangle.cy)
        val area2 = triangleArea(triangle.ax, triangle.ay, triangle.cx, triangle.cy, dx, dy)
        val area3 = triangleArea(triangle.ax, triangle.ay, triangle.bx, triangle.by, dx, dy)

        // Check if the area of ​​the small triangle is equal to the large triangle.
        val isInside = area == area1 + area2 + area3
        _isPointInsideTriangle.value = isInside
    }

    private fun triangleArea(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double): Double {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0)
    }
}
