package com.advance.kotlin

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.blankj.utilcode.util.Utils
import com.tencent.mmkv.MMKV

/**
 * @author xugang
 * @date 2022/4/7
 */
class AdvApplication : Application() {

    companion object {
        var mMainThreadHandler: Handler? = null
    }

    override fun onCreate() {
        super.onCreate()
        mMainThreadHandler = Handler(Looper.getMainLooper())
        Utils.init(this)

        // /data/user/0/项目包名/files/mmkv
        val initialize = MMKV.initialize(this)
        Log.d("mmkv", initialize)

        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }


    class ApplicationLifecycleObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onAppForeground() {
            Log.d("lifecycleApp", "app foreground")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onAppBackground() {
            Log.d("lifecycleApp", "app background")
        }

    }
}