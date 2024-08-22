package com.example.test_1.checkpointtriangle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheckPointTriangleViewModel : ViewModel() {

    private val _points = MutableLiveData<MutableList<Point>>(mutableListOf())
    val points: LiveData<MutableList<Point>> = _points

    // Check point to see if it is inside the triangle or not
    private val _testPoint = MutableLiveData<Point?>()
    val testPoint: LiveData<Point?> = _testPoint

    // Text results after checking points
    private val _resultText = MutableLiveData<String>()
    val resultText: LiveData<String> = _resultText

    fun addPoint(point: Point) {
        if (_points.value?.size ?: 0 < 3) {
            _points.value?.add(point)
        } else {
            _testPoint.value = point
            checkPointInTriangle()
        }
        _points.value = _points.value
    }

    // Reset triangle
    fun resetTriangle() {
        _points.value?.clear()
        _testPoint.value = null
        _resultText.value = null
    }

    // Check if the point is inside the triangle
    private fun checkPointInTriangle() {
        val pts = _points.value ?: return
        if (pts.size == 3 && _testPoint.value != null) {
            val inside = isPointInTriangle(_testPoint.value!!, pts[0], pts[1], pts[2])
            _resultText.value = if (inside) "Điểm nằm trong tam giác" else "Điểm không nằm trong tam giác"
        }
    }

    // Function to determine if the point is inside the triangle
    private fun isPointInTriangle(pt: Point, v1: Point, v2: Point, v3: Point): Boolean {
        val d1 = sign(pt, v1, v2)
        val d2 = sign(pt, v2, v3)
        val d3 = sign(pt, v3, v1)
        val hasNeg = (d1 < 0) || (d2 < 0) || (d3 < 0)
        val hasPos = (d1 > 0) || (d2 > 0) || (d3 > 0)
        return !(hasNeg && hasPos)
    }

    // Direction of the vector formed by three points
    private fun sign(p1: Point, p2: Point, p3: Point): Float {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y)
    }
}
