package com.advance.kotlin

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.advance.kotlin.sort_dialog.ADialog
import com.advance.kotlin.sort_dialog.BDialog
import com.advance.kotlin.sort_dialog.CDialog
import com.advance.kotlin.sort_dialog.DialogChain
import com.advance.kotlin.widget.MarqueeAnimalView
import com.advance.kotlin.widget.PoolViewFactory
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ResourceUtils
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.enums.SidePattern
import com.lzf.easyfloat.interfaces.OnTouchRangeListener
import com.lzf.easyfloat.utils.DragUtils
import com.lzf.easyfloat.widget.BaseSwitchView

/**
 * @author xugang
 * @date 2024/3/18
 */
class SingleActivity : AppCompatActivity() {

    companion object {
        fun startMe(context: Context, fromTag: String) {
            context.startActivity(Intent(context, SingleActivity::class.java).apply {
                putExtra("fromTag", fromTag)
            })
        }
    }

    private lateinit var dialogChain: DialogChain
    private val bDialog by lazy { BDialog(this) }
    private var fromTag: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        intent?.let {
            fromTag = it.getStringExtra("fromTag")!!
        }

        val seekBar = findViewById<SeekBar>(R.id.seekbar)
        val mqv = findViewById<MarqueeAnimalView>(R.id.mqv)

        val tvTag: TextView = findViewById(R.id.tv_tag)
        tvTag.text = fromTag
        if (fromTag == "SeekBar") {
            seekBar.visibility = View.VISIBLE
            seekBar.progress = 0

        } else if (fromTag == "跑马灯") {
            mqv.visibility = View.VISIBLE

            val list = mutableListOf("我是跑马灯1", "我不是跑马灯蛤", "你猜我是不是跑马灯hhh")
            var position = 0
            mqv.setFactory(object : PoolViewFactory {
                override fun makeView(layoutInflater: LayoutInflater, parent: ViewGroup): View {
                    val view = TextView(this@SingleActivity)
                    view.setPadding(ConvertUtils.dp2px(12f), ConvertUtils.dp2px(5f), ConvertUtils.dp2px(12f), ConvertUtils.dp2px(5f))
                    view.textSize = 12f
                    view.setTextColor(resources.getColor(R.color.colorPrimary))
                    view.setBackgroundResource(R.drawable.bg_btn_commit)
                    return view
                }

                override fun setAnimator(
                    objectAnimator: ObjectAnimator,
                    width: Int,
                    parentWidth: Int
                ) {
                    // 根据不同宽度计算动画时间
                    objectAnimator.duration = (parentWidth + width) * 10L
                }

                override fun setView(view: View): Boolean {
                    (view as? TextView)?.text = list[position++ % list.size]
                    return true
                }
            })
        }

        var add = true
        tvTag.setOnClickListener {
            when (fromTag) {
                "Dialog链式调用" -> {
                    createDialogChain() //创建 DialogChain
                    // 模拟延迟数据回调。
                    Handler(Looper.getMainLooper()).postDelayed({
                        bDialog.onDataCallback("延迟数据回来了！！")
                    }, 3000)
                    // 开始从链头弹窗。
                    dialogChain.process()
                }

                "悬浮窗" -> {
                    showAppFloat3("悬浮窗")
                }

                "SeekBar" -> {
                    if (seekBar.progress <= 0) {
                        add = true
                    }
                    if (seekBar.progress >= 100) {
                        add = false
                    }

                    if (add) {
                        seekBar.progress = seekBar.progress + 10
                    } else {
                        seekBar.progress = seekBar.progress - 10
                    }
                }
            }
        }
    }

    //创建 DialogChain
    private fun createDialogChain() {
        dialogChain = DialogChain.create(3)
            .attach(this)
            .addInterceptor(ADialog(this))
            .addInterceptor(bDialog)
            .addInterceptor(CDialog(this))
            .build()
    }


    private fun showAppFloat3(tag: String) {
        EasyFloat.with(this.applicationContext)
            .setTag(tag)
            .setShowPattern(ShowPattern.ALL_TIME)
            .setSidePattern(SidePattern.RESULT_SIDE)
            .setImmersionStatusBar(true)
            .setGravity(Gravity.END, -20, 100)
            .setLayout(R.layout.layout_suspension_view) {

            }
            .registerCallback {
                drag { _, motionEvent ->
                    DragUtils.registerDragClose(motionEvent, object : OnTouchRangeListener {
                        override fun touchInRange(inRange: Boolean, view: BaseSwitchView) {
                            view.findViewById<TextView>(com.lzf.easyfloat.R.id.tv_delete).text =
                                if (inRange) "松手删除" else "删除浮窗"

                            view.findViewById<ImageView>(com.lzf.easyfloat.R.id.iv_delete)
                                .setImageResource(
                                    if (inRange) com.lzf.easyfloat.R.drawable.icon_delete_selected
                                    else com.lzf.easyfloat.R.drawable.icon_delete_normal
                                )
                        }

                        override fun touchUpInRange() {
                            EasyFloat.dismiss(tag)
                        }
                    }, showPattern = ShowPattern.ALL_TIME)
                }
            }
            .show()
    }

}