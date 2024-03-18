package com.advance.kotlin.adapter

import android.content.Intent
import android.widget.TextView
import com.advance.kotlin.R
import com.advance.kotlin.SingleActivity
import com.advance.kotlin.bean.JumpItemChildBean
import com.advance.kotlin.canvas.CanvasClipActivity
import com.advance.kotlin.fragmentvisible.FragmentVisibleActivity
import com.advance.kotlin.home.HomeActivity
import com.advance.kotlin.kline.demo.KDiagramActivity
import com.advance.kotlin.videowebview.VideoWewbViewActivity
import com.advance.kotlin.webviewscroll.WebviewScrollActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.kotlin.scrollingtable.MainTableActivity

/**
 * @author xugang
 * @date 2024/3/18
 */
class MainChildAdapter :
    BaseQuickAdapter<JumpItemChildBean, BaseViewHolder>(R.layout.item_main_child_jump) {

    override fun convert(helper: BaseViewHolder?, item: JumpItemChildBean?) {
        helper?.setText(R.id.tv_item, item?.name)
        helper?.getView<TextView>(R.id.tv_item)?.setOnClickListener {
            when (item?.name) {
                "Dialog链式调用" -> {
                    SingleActivity.startMe(mContext, item.name)
                }

                "悬浮窗" -> {
                    SingleActivity.startMe(mContext, item.name)
                }

                "网页视频全屏播放" -> {
                    mContext.startActivity(Intent(mContext, VideoWewbViewActivity::class.java))
                }

                "顶部小楼" -> {
                    mContext.startActivity(Intent(mContext, HomeActivity::class.java))
                }

                "WebView in scrollView" -> {
                    mContext.startActivity(Intent(mContext, WebviewScrollActivity::class.java))
                }

                "可见性监听" -> {
                    mContext.startActivity(Intent(mContext, FragmentVisibleActivity::class.java))
                }

                "clipPath" -> {
                    mContext.startActivity(Intent(mContext, CanvasClipActivity::class.java))

                }

                "期货列表" -> {
                    mContext.startActivity(Intent(mContext, MainTableActivity::class.java))

                }

                "KChart" -> {
                    mContext.startActivity(Intent(mContext, KDiagramActivity::class.java))
                }

            }
        }
    }
}