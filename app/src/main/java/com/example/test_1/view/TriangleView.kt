package com.example.demo_test.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.example.demo_test.viewmodel.TriangleViewModel
import com.example.test_1.model.Point

class TriangleView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Vẽ các cạnh của tam giác.
    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    // Vẽ các điểm của tam giác.
    private val pointPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    // Paint để vẽ đường viền của TriangleView.
    private val borderPaint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    private lateinit var viewModel: TriangleViewModel
    private lateinit var answerTextView: TextView

    fun setViewModel(viewModel: TriangleViewModel, answerTextView: TextView) {
        this.viewModel = viewModel
        this.answerTextView = answerTextView

        // Quan sát thay đổi của điểm và tam giác.
        viewModel.points.observeForever {
            invalidate()
        }
        viewModel.testPoint.observeForever {
            invalidate()
        }
        viewModel.resultText.observeForever {
            answerTextView.text = it  // Cập nhật kết quả TextView
        }
    }

    /**
     * Phương thức onDraw để vẽ tam giác và các điểm trên Canvas.
     * @param canvas Canvas để vẽ.
     */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Vẽ đường viền cho TriangleView.
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), borderPaint)

        val points = viewModel.points.value ?: emptyList()
        if (points.size == 3) {
            canvas.drawLine(points[0].x, points[0].y, points[1].x, points[1].y, paint)
            canvas.drawLine(points[1].x, points[1].y, points[2].x, points[2].y, paint)
            canvas.drawLine(points[2].x, points[2].y, points[0].x, points[0].y, paint)
        }

        points.forEach { point ->
            canvas.drawCircle(point.x, point.y, 10f, pointPaint)
        }

        viewModel.testPoint.value?.let {
            val inside = viewModel.resultText.value == "Điểm nằm trong tam giác"
            val color = if (inside) Color.GREEN else Color.RED
            pointPaint.color = color
            canvas.drawCircle(it.x, it.y, 10f, pointPaint)
            pointPaint.color = Color.RED
        }
    }

    /**
     * Phương thức xử lý sự kiện chạm trên View.
     * @param event Sự kiện chạm.
     * @return true nếu sự kiện được xử lý.
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val point = Point(event.x, event.y)
            viewModel.addPoint(point)
            invalidate()
        }
        return true
    }
}
