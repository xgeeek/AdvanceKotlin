package com.advance.kotlin.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View

/**
 * @author xugang
 * @date 2023/6/2
 */
class ClipExmView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var viewPaint: Paint = Paint()
    private var redPath = Path()

    init {

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.YELLOW)
        viewPaint.color = Color.parseColor("#00ff00")
        viewPaint.style = Paint.Style.STROKE
        redPath.moveTo(200f,200f)
        redPath.lineTo(200f,200f)
        redPath.lineTo(600f,200f)
        redPath.lineTo(600f,600f)
        redPath.lineTo(200f,600f)
        redPath.close()
        canvas.drawPath(redPath, viewPaint)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //canvas.clipPath(redPath)
        }
        //canvas.drawColor(Color.RED)
    }

}