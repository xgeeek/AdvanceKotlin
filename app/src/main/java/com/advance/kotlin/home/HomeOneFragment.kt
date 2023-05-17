package com.advance.kotlin.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.advance.kotlin.R

/**
 * @author xugang
 * @date 2023/4/12
 */
class HomeOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_home_one, null)
        initView(view)
        return view
    }

    fun initView(view: View) {

    }
}