package com.advance.kotlin.fragmentvisible

import android.util.Log
import com.advance.kotlin.R
import com.advance.kotlin.databinding.FragmentVisibleTwoBinding


/**
 * @author xugang
 * @date 2023/5/17
 */
class FragmentVisibleTwo : BaseFragment() {

    private lateinit var binding: FragmentVisibleTwoBinding


    override fun getLayoutId(): Int = R.layout.fragment_visible_two


    override fun loadData(isLazy: Boolean) {
        Log.d(
            "fragment_visible", "Two  ${
                if (isLazy) {
                    "懒加载"
                } else {
                    "非懒加载"
                }
            }"
        )

        binding = getBinding(FragmentVisibleTwoBinding::class.java)


        val fragments = mutableListOf<BaseFragment>()
        fragments.add(FragmentVisibleTwoA())
        fragments.add(FragmentVisibleTwoB())
        val titles = arrayOf("自选","全部")
        val fragmentAdapter = ViewPagerFragmentAdapter(childFragmentManager, fragments)
        binding.vpQuote.adapter = fragmentAdapter
        binding.vpQuote.offscreenPageLimit = fragments.size

        binding.stlQuote.setViewPager(binding.vpQuote, titles)
    }

    override fun onResume() {
        super.onResume()
        Log.d("fragment_visible", "Two  onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragment_visible", "Two  onPause")
    }
}