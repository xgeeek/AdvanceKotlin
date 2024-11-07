package com.advance.kotlin.glide

import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.advance.kotlin.R
import com.advance.kotlin.bean.JumpItemBean
import com.advance.kotlin.bean.MultiItemBean
import com.advance.kotlin.fold_text_view.SimpleFoldTextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * @author xugang
 * @date 2024/3/18
 */
class GlideIvAdapter() : BaseQuickAdapter<MultiItemBean, BaseViewHolder>(R.layout.item_main_jump_2) {

    override fun convert(holder: BaseViewHolder?, item: MultiItemBean) {
        holder?.setText(R.id.tv_tag, item.name)
        item.let {
            if (item.show) {
                holder?.setImageResource(R.id.iv_arrow, R.drawable.ic_cir_arrow_up)
                holder?.setVisible(R.id.rv_child, true)
            } else {
                holder?.setImageResource(R.id.iv_arrow, R.drawable.ic_cir_arrow_down)
                holder?.setGone(R.id.rv_child, false)
            }
        }
        holder?.getView<LinearLayout>(R.id.ll_tag)?.setOnClickListener {
            item.let {
                if (item.show) {
                    holder.setImageResource(R.id.iv_arrow, R.drawable.ic_cir_arrow_down)
                    holder.setGone(R.id.rv_child, false)
                } else {
                    holder.setImageResource(R.id.iv_arrow, R.drawable.ic_cir_arrow_up)
                    holder.setGone(R.id.rv_child, true)
                }
                item.show = !item.show
            }
        }

        holder?.getView<RecyclerView>(R.id.rv_child)?.let {
            it.layoutManager = LinearLayoutManager(mContext)
            val childAdapter = GlideIvChildAdapter(R.layout.item_multi_iv_center)
            it.adapter = childAdapter
            childAdapter.setNewData(item.childList)
        }

        val tv = holder?.getView<SimpleFoldTextView>(R.id.tv_desc)
        tv?.setContent(item.desc, 0)
    }
}