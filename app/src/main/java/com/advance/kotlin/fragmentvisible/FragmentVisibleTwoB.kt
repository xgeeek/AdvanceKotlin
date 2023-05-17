package com.advance.kotlin.fragmentvisible

import android.util.Log
import com.advance.kotlin.R
import com.advance.kotlin.databinding.FragmentVisibleTwoBBinding
import com.advance.kotlin.utils.AppUtils
import com.advance.kotlin.utils.DefLoadingDialog


/**
 * @author xugang
 * @date 2023/5/17
 */
class FragmentVisibleTwoB : BaseFragment() {

    private lateinit var binding: FragmentVisibleTwoBBinding
    private var loadingDialog: DefLoadingDialog? = null

    override fun getLayoutId(): Int = R.layout.fragment_visible_two_b

    override fun loadData(isLazy: Boolean) {
        loadingDialog = DefLoadingDialog(mContext)
        loadingDialog?.show()
        AppUtils.postDelayed({
            Log.d(
                "fragment_visible", "Two B  ${
                    if (isLazy) {
                        "懒加载"
                    } else {
                        "非懒加载"
                    }
                }"
            )
            binding = getBinding(FragmentVisibleTwoBBinding::class.java)

            val fragments = mutableListOf<BaseFragment>()
            fragments.add(FragmentVisibleTwoBList.getInstance(100))
            fragments.add(FragmentVisibleTwoBList.getInstance(101))
            fragments.add(FragmentVisibleTwoBList.getInstance(102))
            fragments.add(FragmentVisibleTwoBList.getInstance(103))
            fragments.add(FragmentVisibleTwoBList.getInstance(104))
            fragments.add(FragmentVisibleTwoBList.getInstance(105))
            fragments.add(FragmentVisibleTwoBList.getInstance(106))
            fragments.add(FragmentVisibleTwoBList.getInstance(107))
            fragments.add(FragmentVisibleTwoBList.getInstance(108))

            val titles = arrayOf("100","101","102","103","104","105","106","107","108")

            val fragmentAdapter = ViewPagerFragmentAdapter(childFragmentManager, fragments)
            binding.vpQuote.adapter = fragmentAdapter
            binding.vpQuote.offscreenPageLimit = fragments.size

            binding.stlQuote.setViewPager(binding.vpQuote,titles)

            loadingDialog?.dismiss()
        }, 1500)


    }

    override fun needLazyLoadData(): Boolean = true

    override fun onResume() {
        super.onResume()
        Log.d("fragment_visible", "Two B  onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragment_visible", "Two  B  onPause")
    }
}