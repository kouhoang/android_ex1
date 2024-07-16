package com.example.test_1.ui.example2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_1.model.Triangle

class ExampleViewModel2 : ViewModel() {

    // LiveData để lưu trữ thông tin về tam giác.
    private val _triangle = MutableLiveData<Triangle>()
    val triangle: LiveData<Triangle>
        get() = _triangle

    // LiveData để lưu trữ kết quả kiểm tra điểm có nằm trong tam giác hay không.
    private val _isPointInsideTriangle = MutableLiveData<Boolean>()
    val isPointInsideTriangle: LiveData<Boolean>
        get() = _isPointInsideTriangle

    fun setTriangle(ax: Double, ay: Double, bx: Double, by: Double, cx: Double, cy: Double) {
        _triangle.value = Triangle(ax, ay, bx, by, cx, cy)
    }

    // Kiểm tra điểm có nằm trong tam giác không
    fun checkPointInTriangle(dx: Double, dy: Double) {
        val triangle = _triangle.value ?: return

        // Tính diện tích tam giác
        val area = triangleArea(triangle.bx, triangle.by, triangle.cx, triangle.cy, dx, dy)
        val area1 = triangleArea(triangle.ax, triangle.ay, triangle.bx, triangle.by, triangle.cx, triangle.cy)
        val area2 = triangleArea(triangle.ax, triangle.ay, triangle.cx, triangle.cy, dx, dy)
        val area3 = triangleArea(triangle.ax, triangle.ay, triangle.bx, triangle.by, dx, dy)

        // Kiểm tra diện tích các tam giác bé có bằng tam giác to không.
        val isInside = area == area1 + area2 + area3
        _isPointInsideTriangle.value = isInside
    }

    private fun triangleArea(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double): Double {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0)
    }
}
