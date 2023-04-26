package com.example.blackcoffer

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.content.ContextCompat

class CustomMenuIconDrawable(private val context: Context) : DrawerArrowDrawable(context) {
    private val paint = Paint()
    private val density = context.resources.displayMetrics.density
    private val strokeWidth = density * 3 // set stroke width of lines
    private val halfStrokeWidth = strokeWidth / 2
    private val size = density * 27 // set size of drawable

    init {
        paint.color = ContextCompat.getColor(context, R.color.white) // set color of lines
        paint.isAntiAlias = true
        paint.strokeWidth = strokeWidth
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
    }

    override fun draw(canvas: Canvas) {
        val bounds = bounds

        // calculate the position of lines
        val startX = bounds.left.toFloat() + halfStrokeWidth
        val startY = bounds.centerY().toFloat()
        val stopX = bounds.right.toFloat() - halfStrokeWidth
        val stopY = bounds.centerY().toFloat()

        // draw top line
        canvas.drawLine(startX, startY - size / 4, stopX, startY - size / 4, paint)

        // draw middle line
        canvas.drawLine(startX, startY, stopX , startY, paint)

        // draw bottom line
        canvas.drawLine(startX, startY + size / 4, stopX - size / 3, startY + size / 4, paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun getIntrinsicWidth(): Int {
        return size.toInt()
    }

    override fun getIntrinsicHeight(): Int {
        return size.toInt()
    }


}