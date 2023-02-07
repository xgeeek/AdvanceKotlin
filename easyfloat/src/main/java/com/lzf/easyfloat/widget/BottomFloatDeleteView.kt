package com.lzf.easyfloat.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.ImageView
import com.lzf.easyfloat.R
import com.lzf.easyfloat.interfaces.OnTouchRangeListener

/**
 * @author xugang
 * @date 2023/2/7
 */
class BottomFloatDeleteView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseSwitchView(context, attrs, defStyleAttr) {


    private var width = 0f
    private var height = 0f
    private var region = Region()
    private var inRange = false
    private var listener: OnTouchRangeListener? = null

    private var ivDeleteView: ImageView

    init {
        setWillNotDraw(false)
        LayoutInflater.from(context).inflate(R.layout.layout_suspension_delete, this)
        ivDeleteView = findViewById(R.id.iv_sus_bottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w.toFloat()
        height = h.toFloat()
        region.set(0, 0, w, h)
    }

    override fun onDraw(canvas: Canvas?) {
        if (inRange) {
            ivDeleteView.setImageResource(R.drawable.img_float_delete_contain)
        } else {
            ivDeleteView.setImageResource(R.drawable.img_float_delete_normal)
        }
        super.onDraw(canvas)
    }

    override fun setTouchRangeListener(event: MotionEvent, listener: OnTouchRangeListener?) {
        this.listener = listener
        initTouchRange(event)
    }

    private fun initTouchRange(event: MotionEvent): Boolean {
        val location = IntArray(2)
        // 获取在整个屏幕内的绝对坐标
        getLocationOnScreen(location)
        val currentInRange = region.contains(
            event.rawX.toInt() - location[0], event.rawY.toInt() - location[1]
        )
        if (currentInRange != inRange) {
            inRange = currentInRange
            invalidate()
        }
        listener?.touchInRange(currentInRange, this)
        if (event.action == MotionEvent.ACTION_UP && currentInRange) {
            listener?.touchUpInRange()
        }
        return currentInRange
    }

}