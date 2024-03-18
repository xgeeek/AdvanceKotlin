package com.advance.kotlin.adapter

import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.advance.kotlin.R
import com.advance.kotlin.bean.JumpItemBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * @author xugang
 * @date 2024/3/18
 */
class MainAdapter() : BaseQuickAdapter<JumpItemBean, BaseViewHolder>(R.layout.item_main_jump) {

    override fun convert(holder: BaseViewHolder?, item: JumpItemBean?) {
        holder?.setText(R.id.tv_tag, item?.tag)
        item?.let {
            if (item.show) {
                holder?.setImageResource(R.id.iv_arrow, R.drawable.ic_cir_arrow_up)
                holder?.setVisible(R.id.rv_child, true)
            } else {
                holder?.setImageResource(R.id.iv_arrow, R.drawable.ic_cir_arrow_down)
                holder?.setGone(R.id.rv_child, false)
            }
        }
        holder?.getView<LinearLayout>(R.id.ll_tag)?.setOnClickListener {
            item?.let {
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
            val childAdapter = MainChildAdapter()
            it.adapter = childAdapter
            childAdapter.setNewData(item?.childList)
        }
    }
}