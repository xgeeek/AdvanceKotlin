package com.advance.kotlin.utils

import com.advance.kotlin.AdvApplication

/**
 * @author xugang
 * @date 2023/5/17
 */
object AppUtils {

    fun postDelayed(task: Runnable, delay: Long) {
        AdvApplication.mMainThreadHandler?.postDelayed(task, delay)
    }
}