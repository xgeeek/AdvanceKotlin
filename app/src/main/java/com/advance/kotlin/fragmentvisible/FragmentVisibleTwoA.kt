package com.advance.kotlin.fragmentvisible

import android.util.Log
import com.advance.kotlin.R
import com.advance.kotlin.databinding.FragmentVisibleTwoABinding
import com.advance.kotlin.databinding.FragmentVisibleTwoBinding


/**
 * @author xugang
 * @date 2023/5/17
 */
class FragmentVisibleTwoA : BaseFragment() {

    private lateinit var binding: FragmentVisibleTwoABinding


    override fun getLayoutId(): Int = R.layout.fragment_visible_two_a

    override fun loadData(isLazy: Boolean) {
        Log.d(
            "fragment_visible", "Two A  ${
                if (isLazy) {
                    "懒加载"
                } else {
                    "非懒加载"
                }
            }"
        )
        binding = getBinding(FragmentVisibleTwoABinding::class.java)
    }

    override fun onResume() {
        super.onResume()
        Log.d("fragment_visible", "Two A  onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragment_visible", "Two A  onPause")
    }
}