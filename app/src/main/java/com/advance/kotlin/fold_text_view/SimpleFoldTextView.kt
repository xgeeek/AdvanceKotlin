package com.advance.kotlin.fold_text_view

import android.content.Context
import android.graphics.Typeface
import android.text.Layout
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.StaticLayout
import android.text.method.LinkMovementMethod
import android.text.style.StyleSpan
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.advance.kotlin.R
import com.blankj.utilcode.util.SizeUtils

/**
 * @author xugang
 * @date 2024/8/23
 */
class SimpleFoldTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var tvFold1: TextView
    private var tvFold2: TextView


    init {
        val view = inflate(getContext(), R.layout.view_simple_fold_text, this)
        tvFold1 = view.findViewById(R.id.tv_fold_1)
        tvFold2 = view.findViewById(R.id.tv_fold_2)
        val llFold = view.findViewById<LinearLayout>(R.id.ll_fold)
        val llExpand = view.findViewById<RelativeLayout>(R.id.ll_expand)
        val tvExpand = view.findViewById<TextView>(R.id.tv_expand)

        view.findViewById<TextView>(R.id.tv_fold_tag).setOnClickListener {
            llFold.visibility = View.GONE
            llExpand.visibility = View.VISIBLE
        }

        val tvExpandTag = view.findViewById<TextView>(R.id.tv_expand_tag)
        tvExpandTag.setOnClickListener {
            llFold.visibility = View.VISIBLE
            llExpand.visibility = View.GONE
        }


        val content = resources.getString(R.string.foot_tip_average)
        val span = SpannableStringBuilder()
        span.append(content)
        span.setSpan(StyleSpan(Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvFold1.movementMethod = LinkMovementMethod.getInstance()
        tvExpand.movementMethod = LinkMovementMethod.getInstance()

        tvFold1.text = span
        tvExpand.text = span

        tvFold1.post {
            val staticLayout = StaticLayout(
                content, tvFold1.paint, tvFold1.measuredWidth, Layout.Alignment.ALIGN_NORMAL,
                1.0f, 0.0f, false,
            )
            Log.d("SimpleFoldTextView", "tvFold1.text.toString() = ${staticLayout.getLineEnd(0)}")

            tvFold2.text = content.substring(staticLayout.getLineEnd(0), content.length)
        }


        tvExpand.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // 现在可以安全地获取 Layout
                val layout = tvExpand.layout
                if (layout != null) {
                    val lastLineWidth = layout.getLineWidth(layout.lineCount - 1)
                    val textViewWidth =
                        tvExpand.width.toFloat() - tvExpand.totalPaddingLeft - tvExpand.totalPaddingRight
                    if (lastLineWidth >= (textViewWidth * 0.95f - SizeUtils.dp2px(30f))) {
                        val params = RelativeLayout.LayoutParams(
                            SizeUtils.dp2px(30f),
                            RelativeLayout.LayoutParams.WRAP_CONTENT
                        )
                        params.addRule(RelativeLayout.ALIGN_PARENT_END)
                        params.addRule(RelativeLayout.BELOW, R.id.tv_expand)
                        tvExpandTag.layoutParams = params
                    }else{
                        val params = RelativeLayout.LayoutParams(
                            SizeUtils.dp2px(30f),
                            SizeUtils.dp2px(18f)
                        )
                        params.addRule(RelativeLayout.ALIGN_PARENT_END)
                        params.addRule(RelativeLayout.BELOW, R.id.tv_expand)
                        params.topMargin = -SizeUtils.dp2px(18f)
                        tvExpandTag.layoutParams = params
                    }

                    // 移除监听器，防止多次触发
                    tvExpand.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            }
        })

    }

}