package com.advance.kotlin.glide

import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.advance.kotlin.R
import com.advance.kotlin.bean.MultiItemChildBean
import com.advance.kotlin.fold_text_view.SimpleFoldTextView
import com.advance.kotlin.utils.AppConstant
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.SizeUtils
import com.blankj.utilcode.util.Utils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * @author xugang
 * @date 2024/9/3
 */
class GlideIvChildAdapter(layoutId: Int) :
    BaseQuickAdapter<MultiItemChildBean, BaseViewHolder>(layoutId) {


    override fun convert(helper: BaseViewHolder, item: MultiItemChildBean) {
        val ivShow = helper.getView<ImageView>(R.id.iv_show)

        when (item.type) {
            AppConstant.Multi_ITEM_IV_CENTER -> {
                ivShow.setImageResource(R.drawable.iv_glide_test)
                ivShow.scaleType = ImageView.ScaleType.CENTER
            }

            AppConstant.Multi_ITEM_IV_CENTER_CROP -> {
                ivShow.setImageResource(R.drawable.iv_glide_test)
                ivShow.scaleType = ImageView.ScaleType.CENTER_CROP
            }

            AppConstant.Multi_ITEM_IV_CENTER_INSIDE -> {
                ivShow.setImageResource(R.drawable.iv_glide_test)
                ivShow.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }

            AppConstant.Multi_ITEM_IV_FIT_XY -> {
                ivShow.setImageResource(R.drawable.iv_glide_test)
                ivShow.scaleType = ImageView.ScaleType.FIT_XY
            }

            AppConstant.Multi_ITEM_IV_FIT_CENTER -> {
                ivShow.setImageResource(R.drawable.iv_glide_test)
                ivShow.scaleType = ImageView.ScaleType.FIT_CENTER
            }

            AppConstant.Multi_ITEM_GLIDE_FIT_CENTER -> {
                ivShow.scaleType = ImageView.ScaleType.CENTER
                Glide.with(mContext)
                    .load(R.drawable.iv_glide_test)
                    .fitCenter()
                    .into(ivShow)
            }

            AppConstant.Multi_ITEM_GLIDE_CENTER_INSIDE -> {
                ivShow.scaleType = ImageView.ScaleType.CENTER
                Glide.with(mContext)
                    .load(R.drawable.iv_glide_test)
                    .centerInside()
                    .into(ivShow)
            }

            AppConstant.Multi_ITEM_GLIDE_CENTER_CROP -> {
                ivShow.scaleType = ImageView.ScaleType.CENTER
                Glide.with(mContext)
                    .load(R.drawable.iv_glide_test)
                    .centerCrop()
                    .into(ivShow)
            }

        }


        when (item.itemName) {
            "长宽长高" -> {
                // 159  120
                val params = ConstraintLayout.LayoutParams(
                    SizeUtils.dp2px(200f),
                    SizeUtils.dp2px(200f)
                )
                params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                ivShow.layoutParams = params
            }

            "中宽中高" -> {
                val params = ConstraintLayout.LayoutParams(
                    SizeUtils.dp2px(159f),
                    SizeUtils.dp2px(120f)
                )
                params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                ivShow.layoutParams = params
            }

            "短宽短高" -> {
                val params = ConstraintLayout.LayoutParams(
                    SizeUtils.dp2px(100f),
                    SizeUtils.dp2px(100f)
                )
                params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                ivShow.layoutParams = params
            }
        }
        val tv = helper.getView<SimpleFoldTextView>(R.id.stv)
        tv.setContent(item.itemDesc, 0)

    }


}