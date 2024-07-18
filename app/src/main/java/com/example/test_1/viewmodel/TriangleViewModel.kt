package com.example.demo_test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_1.model.Point

class TriangleViewModel : ViewModel() {

    // Danh sách các điểm của tam giác
    private val _points = MutableLiveData<MutableList<Point>>(mutableListOf())
    val points: LiveData<MutableList<Point>> = _points

    // Điểm kiểm tra xem có nằm trong tam giác hay không
    private val _testPoint = MutableLiveData<Point?>()
    val testPoint: LiveData<Point?> = _testPoint

    // Kết quả văn bản sau khi kiểm tra điểm
    private val _resultText = MutableLiveData<String>()
    val resultText: LiveData<String> = _resultText

    // Thêm một điểm vào danh sách tam giác
    fun addPoint(point: Point) {
        if (_points.value?.size ?: 0 < 3) {
            _points.value?.add(point)
        } else {
            _testPoint.value = point
            checkPointInTriangle()
        }
        _points.value = _points.value
    }

    // Reset lại tam giác
    fun resetTriangle() {
        _points.value?.clear()
        _testPoint.value = null
        _resultText.value = null
    }

    // Kiểm tra xem điểm có nằm trong tam giác không
    private fun checkPointInTriangle() {
        val pts = _points.value ?: return
        if (pts.size == 3 && _testPoint.value != null) {
            val inside = isPointInTriangle(_testPoint.value!!, pts[0], pts[1], pts[2])
            _resultText.value = if (inside) "Điểm nằm trong tam giác" else "Điểm không nằm trong tam giác"
        }
    }

    // Hàm xác định xem điểm có nằm trong tam giác không
    private fun isPointInTriangle(pt: Point, v1: Point, v2: Point, v3: Point): Boolean {
        val d1 = sign(pt, v1, v2)
        val d2 = sign(pt, v2, v3)
        val d3 = sign(pt, v3, v1)
        val hasNeg = (d1 < 0) || (d2 < 0) || (d3 < 0)
        val hasPos = (d1 > 0) || (d2 > 0) || (d3 > 0)
        return !(hasNeg && hasPos)
    }

    // Hướng của vectơ hình thành bởi ba điểm
    private fun sign(p1: Point, p2: Point, p3: Point): Float {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y)
    }
}
