package com.advance.kotlin

import android.app.Application
import android.util.Log
import com.tencent.mmkv.MMKV

/**
 * @author xugang
 * @date 2022/4/7
 */
class AdvApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // /data/user/0/项目包名/files/mmkv
        val initialize = MMKV.initialize(this)
        Log.d("mmkv", initialize)
    }
}