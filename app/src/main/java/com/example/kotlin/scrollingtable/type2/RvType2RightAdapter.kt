package com.example.kotlin.scrollingtable.type2

import com.advance.kotlin.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by kotlin on 18-1-29.
 */
class RvType2RightAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_layout_type1) {
    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.tv_data, item)
    }
}
