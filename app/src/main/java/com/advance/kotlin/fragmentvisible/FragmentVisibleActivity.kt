package com.advance.kotlin.fragmentvisible

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.advance.kotlin.R
import com.advance.kotlin.databinding.ActivityFragmentVisibleBinding

/**
 * @author xugang
 * @date 2023/5/17
 */
class FragmentVisibleActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener{

    private lateinit var binding: ActivityFragmentVisibleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_visible)

        val fragments = mutableListOf<BaseFragment>()
        fragments.add(FragmentVisibleOne())
        fragments.add(FragmentVisibleTwo())
        fragments.add(FragmentVisibleThree())
        fragments.add(FragmentVisibleFour())
        val fragmentAdapter = ViewPagerFragmentAdapter(supportFragmentManager, fragments)
        binding.vpMain.adapter = fragmentAdapter
        binding.vpMain.offscreenPageLimit = fragments.size
        binding.vpMain.setCurrentItem(0, false)
        binding.group.check(R.id.rb_mrb_tab_home)

        binding.group.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.rb_mrb_tab_home -> {
                binding.vpMain.setCurrentItem(0, false)
            }
            R.id.rb_mrb_tab_quote -> {
                binding.vpMain.setCurrentItem(1, false)
            }
            R.id.rb_mrb_tab_td -> {
                binding.vpMain.setCurrentItem(2, false)
            }
            R.id.rb_mrb_tab_communication -> {
                binding.vpMain.setCurrentItem(3, false)
            }
        }
    }

}