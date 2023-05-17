package com.advance.kotlin.fragmentvisible

import android.util.Log
import com.advance.kotlin.R
import com.advance.kotlin.databinding.FragmentVisibleOneBinding


/**
 * @author xugang
 * @date 2023/5/17
 */
class FragmentVisibleFour : BaseFragment() {
    private lateinit var binding: FragmentVisibleOneBinding


    override fun getLayoutId(): Int = R.layout.fragment_visible_one

    override fun loadData(isLazy: Boolean) {
        binding = getBinding(FragmentVisibleOneBinding::class.java)
        Log.d(
            "fragment_visible", "Four  ${
                if (isLazy) {
                    "懒加载"
                } else {
                    "非懒加载"
                }
            }"
        )
        binding.tvOne.text = "我的"
    }

    override fun needLazyLoadData(): Boolean = true

    override fun onResume() {
        super.onResume()
        Log.d("fragment_visible", "Four onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragment_visible", "Four onPause")
    }
}