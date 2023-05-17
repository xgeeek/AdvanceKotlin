package com.advance.kotlin.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.advance.kotlin.R
import com.advance.kotlin.utils.FragmentUtils
import com.scwang.smart.refresh.layout.SmartRefreshLayout

/**
 * @author xugang
 * @date 2023/4/12
 */
class HomeActivity : AppCompatActivity() {

    private lateinit var smartRefresh: SmartRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        smartRefresh = findViewById(R.id.smart_refresh)

        smartRefresh.setOnRefreshListener {
            smartRefresh.closeHeaderOrFooter()
        }

        FragmentUtils.replace(supportFragmentManager, HomeOneFragment(), R.id.fl_content)
    }


}