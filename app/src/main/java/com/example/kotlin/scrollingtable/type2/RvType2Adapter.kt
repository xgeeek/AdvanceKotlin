package com.example.kotlin.scrollingtable.type2

import androidx.recyclerview.widget.RecyclerView
import com.advance.kotlin.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.kotlin.scrollingtable.type2.model.Type2Model

/**
 * 每一行的股票信息，第一条是股票名称，之后的是价格信息
 * Created by kotlin on 18-1-29.
 */
class RvType2Adapter : BaseQuickAdapter<Type2Model, BaseViewHolder>(R.layout.item_layout_type2) {
    private var TAG = RvType2Adapter::class.java.name


    override fun convert(helper: BaseViewHolder, item: Type2Model) {
        //当前的条目位置信息
        val productPosition = helper.adapterPosition

        helper.setText(R.id.tv_product_name, item.productName)

        val rightAdapter = RvType2RightAdapter()
        rightAdapter.setNewData(item.mPriceList)
        val itemRecyclerView = helper.getView<RecyclerView>(R.id.rv_list_right)

        itemRecyclerView.adapter = rightAdapter

    }
}
