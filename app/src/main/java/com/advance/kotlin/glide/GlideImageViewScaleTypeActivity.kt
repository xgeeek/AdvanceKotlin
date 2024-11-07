package com.advance.kotlin.glide

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.advance.kotlin.R
import com.advance.kotlin.base.BaseActivity
import com.advance.kotlin.bean.MultiItemBean
import com.advance.kotlin.bean.MultiItemChildBean
import com.advance.kotlin.utils.AppConstant
import com.bumptech.glide.Glide

/**
 * @author xugang
 * @date 2024/9/2
 */
class GlideImageViewScaleTypeActivity : BaseActivity() {

    companion object {
        fun startMe(context: Context) {
            context.startActivity(
                Intent(
                    context,
                    GlideImageViewScaleTypeActivity::class.java
                ).apply {
                })
        }
    }


    private lateinit var rvIv: RecyclerView

    override fun getLayoutId(): Int = R.layout.activty_glide_image_view_scale_type

    override fun initView() {
        val ivTest = findViewById<ImageView>(R.id.iv_test)
        //ivTest.scaleType = ImageView.ScaleType.FIT_XY
        Glide.with(mContext)
            .load(R.drawable.iv_glide_test)
            //.override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
            //.centerCrop()
            .into(ivTest)

        rvIv = findViewById(R.id.rv_iv)
        rvIv.layoutManager = LinearLayoutManager(mContext)
        val ivAdapter = GlideIvAdapter()
        rvIv.adapter = ivAdapter

        val data = mutableListOf<MultiItemBean>()
        // CENTER
        val centerData = mutableListOf<MultiItemChildBean>()
        centerData.add(
            MultiItemChildBean(
                "长宽长高",
                "原图159*120  当前200*200  居中显示，不缩放，留白",
                AppConstant.Multi_ITEM_IV_CENTER
            )
        )
        centerData.add(
            MultiItemChildBean(
                "中宽中高",
                "原图159*120  当前159*120  居中显示，原图大小",
                AppConstant.Multi_ITEM_IV_CENTER
            )
        )
        centerData.add(
            MultiItemChildBean(
                "短宽短高",
                "原图159*120  当前100*100  居中显示，不缩放，裁剪",
                AppConstant.Multi_ITEM_IV_CENTER
            )
        )
        data.add(
            MultiItemBean(
                "ImageView_Center",
                centerData,
                false,
                "center是最老实的显示方式, 将Bitmap进行老老实实居中显示, 也不放大, 也不缩小. 控件比Bitmap大, Bitmap就留白显示; 控件比Bitmap小, 就裁剪."
            )
        )

        // CENTER_CROP
        val centerCropData = mutableListOf<MultiItemChildBean>()
        centerCropData.add(
            MultiItemChildBean(
                "长宽长高",
                "原图159*120  当前200*200  居中显示，图片宽高等比例放大，直到充满imageview，等bitmap高度放大到充满imageview，imageview被充满，bitmap宽度已经超出，会被裁剪",
                AppConstant.Multi_ITEM_IV_CENTER_CROP
            )
        )
        centerCropData.add(
            MultiItemChildBean(
                "中宽中高",
                "原图159*120  当前159*120  居中显示，原图大小",
                AppConstant.Multi_ITEM_IV_CENTER_CROP
            )
        )
        centerCropData.add(
            MultiItemChildBean(
                "短宽短高",
                "原图159*120  当前100*100  居中显示，图片宽高等比例缩小，直到充满imageview，bitmap高度缩小到充满imageview时，imageview被充满，bitmap宽度仍然超出，会被裁剪",
                AppConstant.Multi_ITEM_IV_CENTER_CROP
            )
        )
        data.add(
            MultiItemBean(
                "ImageView_Center_Crop",
                centerCropData,
                false,
                "center_corp, 是将图像从View中间开始长宽等比例放大\\缩小, 直到View的所有区域都被覆盖掉. 此时必然有一个方向(长\\宽)是显示完全的图像 然后很可能会有一个方向的图像被裁剪掉(除非图像和View的比例完全一样), 所以命名叫center_corp, corp有裁剪的意思"
            )
        )


        // CENTER_INSIDE
        val centerInsideData = mutableListOf<MultiItemChildBean>()
        centerInsideData.add(
            MultiItemChildBean(
                "长宽长高",
                "原图159*120  当前200*200  居中显示，图片宽高小于imageview，bitmap显示完全，无需缩放，有留白",
                AppConstant.Multi_ITEM_IV_CENTER_INSIDE
            )
        )
        centerInsideData.add(
            MultiItemChildBean(
                "中宽中高",
                "原图159*120  当前159*120  居中显示，原图大小",
                AppConstant.Multi_ITEM_IV_CENTER_INSIDE
            )
        )
        centerInsideData.add(
            MultiItemChildBean(
                "短宽短高",
                "原图159*120  当前100*100  居中显示，图片宽高等比例缩小，直到bitmap显示完全，有留白",
                AppConstant.Multi_ITEM_IV_CENTER_INSIDE
            )
        )
        data.add(
            MultiItemBean(
                "ImageView_Center_Inside",
                centerInsideData,
                false,
                "center_inside,是图像从View中心长宽等比例缩放，直到Bitmap显示完全,如果图像的大小本身就小于View的大小，那就不缩放了，此时，View的部分区域可能会空白显示(除非View和Bitmap的长宽比例一致)，所以命名为CENTER_INSIDE，图像一定在View的中间"
            )
        )


        // FIT_XY
        val fitXYData = mutableListOf<MultiItemChildBean>()
        fitXYData.add(
            MultiItemChildBean(
                "长宽长高",
                "原图159*120  当前200*200  居中显示，图片宽高小于imageview，bitmap宽高不同比例放大，直到view显示完全一致",
                AppConstant.Multi_ITEM_IV_FIT_XY
            )
        )
        fitXYData.add(
            MultiItemChildBean(
                "中宽中高",
                "原图159*120  当前159*120  居中显示，原图大小",
                AppConstant.Multi_ITEM_IV_FIT_XY
            )
        )
        fitXYData.add(
            MultiItemChildBean(
                "短宽短高",
                "原图159*120  当前100*100  居中显示，图片宽高大于imageview，bitmap宽高不同比例缩小，直到view显示完全一致",
                AppConstant.Multi_ITEM_IV_FIT_XY
            )
        )
        data.add(
            MultiItemBean(
                "ImageView_Fit_Xy",
                fitXYData,
                false,
                "fit_xy, bitmap的x和y方向发生不等比例的缩放, 直到和View的显示完全一致"
            )
        )



        // FIT_CENTER
        val fitCenterData = mutableListOf<MultiItemChildBean>()
        fitCenterData.add(
            MultiItemChildBean(
                "长宽长高",
                "原图159*120  当前200*200  居中显示，图片宽高小于imageview，bitmap宽高同比例放大，宽度先充满，高度留白",
                AppConstant.Multi_ITEM_IV_FIT_CENTER
            )
        )
        fitCenterData.add(
            MultiItemChildBean(
                "中宽中高",
                "原图159*120  当前159*120  居中显示，原图大小",
                AppConstant.Multi_ITEM_IV_FIT_CENTER
            )
        )
        fitCenterData.add(
            MultiItemChildBean(
                "短宽短高",
                "原图159*120  当前100*100  居中显示，图片宽高大于imageview，bitmap宽高同比例缩小，宽度先充满，高度留白",
                AppConstant.Multi_ITEM_IV_FIT_CENTER
            )
        )
        data.add(
            MultiItemBean(
                "ImageView_Fit_Center",
                fitCenterData,
                false,
                "fit_center,将图像进行缩放, 直到有一个方向撑满view. 只要bitmap有任意一边比view大下, fit_center与center_inside效果一样. 注意默认效果是fitCenter"
            )
        )


        // CENTER_INSIDE
        val centerInsideGlideData = mutableListOf<MultiItemChildBean>()
        centerInsideGlideData.add(
            MultiItemChildBean(
                "长宽长高",
                "原图159*120  当前200*200  居中显示，图片宽高小于imageview",
                AppConstant.Multi_ITEM_GLIDE_CENTER_INSIDE
            )
        )
        centerInsideGlideData.add(
            MultiItemChildBean(
                "中宽中高",
                "原图159*120  当前159*120  居中显示，原图大小",
                AppConstant.Multi_ITEM_GLIDE_CENTER_INSIDE
            )
        )
        centerInsideGlideData.add(
            MultiItemChildBean(
                "短宽短高",
                "原图159*120  当前100*100  居中显示，图片宽高大于imageview，bitmap宽高同比例缩小，宽度先充满，高度留白",
                AppConstant.Multi_ITEM_GLIDE_CENTER_INSIDE
            )
        )
        data.add(
            MultiItemBean(
                "Glide_Center_Inside",
                centerInsideGlideData,
                false,
                "glide center_inside,如果图片宽高小于imageview，则居中显示，否则和imageview的fitCenter效果一样，等比例缩放直到有一个方向撑满view，会留白"
            )
        )


        // FIT_CENTER
        val fitCenterGlideData = mutableListOf<MultiItemChildBean>()
        fitCenterGlideData.add(
            MultiItemChildBean(
                "长宽长高",
                "原图159*120  当前200*200  居中显示，图片宽高小于imageview，bitmap宽高同比例放大，宽度先充满，高度留白",
                AppConstant.Multi_ITEM_GLIDE_FIT_CENTER
            )
        )
        fitCenterGlideData.add(
            MultiItemChildBean(
                "中宽中高",
                "原图159*120  当前159*120  居中显示，原图大小",
                AppConstant.Multi_ITEM_GLIDE_FIT_CENTER
            )
        )
        fitCenterGlideData.add(
            MultiItemChildBean(
                "短宽短高",
                "原图159*120  当前100*100  居中显示，图片宽高大于imageview，bitmap宽高同比例缩小，宽度先充满，高度留白",
                AppConstant.Multi_ITEM_GLIDE_FIT_CENTER
            )
        )
        data.add(
            MultiItemBean(
                "Glide_Fit_Center",
                fitCenterGlideData,
                false,
                "fit_center,将图像进行等比例缩放, 直到有一个方向撑满view."
            )
        )


        // CENTER_CROP
        val centerCropGlideData = mutableListOf<MultiItemChildBean>()
        centerCropGlideData.add(
            MultiItemChildBean(
                "长宽长高",
                "原图159*120  当前200*200  居中显示，图片宽高小于imageview，bitmap宽高同比例放大，宽度先充满，高度留白",
                AppConstant.Multi_ITEM_GLIDE_CENTER_CROP
            )
        )
        centerCropGlideData.add(
            MultiItemChildBean(
                "中宽中高",
                "原图159*120  当前159*120  居中显示，原图大小",
                AppConstant.Multi_ITEM_GLIDE_CENTER_CROP
            )
        )
        centerCropGlideData.add(
            MultiItemChildBean(
                "短宽短高",
                "原图159*120  当前100*100  居中显示，图片宽高大于imageview，bitmap宽高同比例缩小，宽度先充满，高度留白",
                AppConstant.Multi_ITEM_GLIDE_CENTER_CROP
            )
        )
        data.add(
            MultiItemBean(
                "Glide_Center_Crop",
                centerCropGlideData,
                false,
                "center_crop,和imageview一样，将图像进行缩放，直到imageview被铺满，会被裁剪"
            )
        )

        ivAdapter.setNewData(data)
    }
}