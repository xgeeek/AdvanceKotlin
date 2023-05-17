package com.advance.kotlin.fragmentvisible

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.advance.kotlin.R
import com.advance.kotlin.databinding.FragmentVisibleTwoBListBinding
import com.advance.kotlin.databinding.FragmentVisibleTwoBinding
import com.advance.kotlin.home.HomeActivity
import com.advance.kotlin.utils.AppUtils
import com.advance.kotlin.utils.DefLoadingDialog


/**
 * @author xugang
 * @date 2023/5/17
 */
class FragmentVisibleTwoBList : BaseFragment() {

    companion object {
        fun getInstance(id: Int): FragmentVisibleTwoBList {
            return FragmentVisibleTwoBList().apply {
                arguments = Bundle().apply {
                    putInt("mid", id)
                }
            }
        }
    }

    private lateinit var binding: FragmentVisibleTwoBListBinding
    private var mId: Int? = 0
    private var loadingDialog: DefLoadingDialog? = null

    override fun getLayoutId(): Int = R.layout.fragment_visible_two_b_list

    override fun loadData(isLazy: Boolean) {
        mId = arguments?.getInt("mid", 0)!!
        binding = getBinding(FragmentVisibleTwoBListBinding::class.java)
        loadingDialog = DefLoadingDialog(mContext)
        loadingDialog?.show()
        AppUtils.postDelayed({
            Log.d(
                "fragment_visible", "Two B List  ${
                    if (isLazy) {
                        "懒加载"
                    } else {
                        "非懒加载"
                    }
                }"
            )
            binding.tvId.text = mId.toString()
            binding.tvId.setOnClickListener {
                startActivity(Intent(mContext, HomeActivity::class.java))
            }
            loadingDialog?.dismiss()
        },1000)
    }

    override fun needLazyLoadData(): Boolean = true

    override fun onResume() {
        super.onResume()
        Log.d("fragment_visible", "Two B list $mId  onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragment_visible", "Two B list $mId  onPause")
    }
}