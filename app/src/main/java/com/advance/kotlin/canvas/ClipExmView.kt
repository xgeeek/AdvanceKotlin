package com.advance.kotlin.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.View
import com.advance.kotlin.R
import com.blankj.utilcode.util.ResourceUtils

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

        //记录图层状态
        val save = canvas.save()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            canvas.clipPath(redPath)
        }
        // 纯色
        //canvas.drawColor(Color.RED)
        // 渐变色
        val drawable = ResourceUtils.getDrawable(R.drawable.path_fill_red)
        drawable.setBounds(0,200, 600, 600)
        drawable.draw(canvas)
        /// 恢复图层
        canvas.restoreToCount(save)

        viewPaint.color = Color.parseColor("#0000ff")
        val rectF = RectF(200f, 600f, 600f, 1400f)
        canvas.drawRect(rectF,viewPaint)
    }

}