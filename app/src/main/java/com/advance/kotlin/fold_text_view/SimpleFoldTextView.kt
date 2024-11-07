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
import android.view.View
import android.view.ViewTreeObserver
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

    private var llFold: LinearLayout
    private var llExpand: RelativeLayout
    private var tvExpand: TextView
    private var llFoldTag:LinearLayout
    private var llExpandTag:LinearLayout

    private var content: String? = ""
    private var boldLength: Int = 4

    init {
        val view = inflate(getContext(), R.layout.view_simple_fold_text, this)
        llFold = view.findViewById(R.id.ll_fold)
        tvFold1 = view.findViewById(R.id.tv_fold_1)
        tvFold2 = view.findViewById(R.id.tv_fold_2)
        llFoldTag = view.findViewById(R.id.ll_fold_tag)

        llExpand = view.findViewById(R.id.ll_expand)
        tvExpand = view.findViewById(R.id.tv_expand)
        llExpandTag = view.findViewById(R.id.ll_expand_tag)

        llFoldTag.setOnClickListener {
            llFold.visibility = View.GONE
            llExpand.visibility = View.VISIBLE
        }

        llExpandTag.setOnClickListener {
            llFold.visibility = View.VISIBLE
            llExpand.visibility = View.GONE
        }

    }

    fun setExpand() {
        try {
            llFold.visibility = View.GONE
            llExpand.visibility = View.VISIBLE
        } catch (_: Exception) {
        }
    }

    fun setFold() {
        try {
            llFold.visibility = View.VISIBLE
            llExpand.visibility = View.GONE
        } catch (_: Exception) {
        }
    }

    fun setContent(content: String, boldLength: Int) {
        try {
            this.content = content
            this.boldLength = boldLength

            val span = SpannableStringBuilder()
            span.append(content)
            span.setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                boldLength,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            tvFold1.movementMethod = LinkMovementMethod.getInstance()
            tvExpand.movementMethod = LinkMovementMethod.getInstance()

            tvFold1.text = span
            tvExpand.text = span

            tvFold1.post {
                val staticLayout = StaticLayout(
                    content, tvFold1.paint, tvFold1.measuredWidth, Layout.Alignment.ALIGN_NORMAL,
                    1.0f, 0.0f, false,
                )

                tvFold2.text = content.substring(staticLayout.getLineEnd(0), content.length)
            }


            tvExpand.viewTreeObserver.addOnGlobalLayoutListener(object :
                ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    try {// 现在可以安全地获取 Layout
                        val layout = tvExpand.layout
                        if (layout != null) {
                            val lastLineWidth = layout.getLineWidth(layout.lineCount - 1)
                            val textViewWidth =
                                tvExpand.width.toFloat() - tvExpand.totalPaddingLeft - tvExpand.totalPaddingRight
                            if (lastLineWidth >= (textViewWidth * 0.95f - SizeUtils.dp2px(60f))) {
                                val params = RelativeLayout.LayoutParams(
                                    SizeUtils.dp2px(60f),
                                    SizeUtils.dp2px(15f)
                                )
                                params.addRule(RelativeLayout.ALIGN_PARENT_END)
                                params.addRule(RelativeLayout.BELOW, R.id.tv_expand)
                                llExpandTag.layoutParams = params
                            } else {
                                val params = RelativeLayout.LayoutParams(
                                    SizeUtils.dp2px(60f),
                                    SizeUtils.dp2px(15f)
                                )
                                params.addRule(RelativeLayout.ALIGN_PARENT_END)
                                params.addRule(RelativeLayout.BELOW, R.id.tv_expand)
                                params.topMargin = -SizeUtils.dp2px(15f)
                                llExpandTag.layoutParams = params
                            }

                            // 移除监听器，防止多次触发
                            tvExpand.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        }
                    } catch (_: Exception) {
                    }
                }
            })
        } catch (_: Exception) {
        }
    }

}