package com.advance.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.advance.kotlin.grammar.zCoroutine.CoroutineMainActivity

class MainActivity : AppCompatActivity() {

    val TAG = "livedata"

    val mLiveData = MutableLiveData<String>()
    lateinit var foreverObj: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLiveData.observe(this, {
            Log.i(TAG, "onchanged: $it")
        })
        Log.i(TAG, "onCreate")
        mLiveData.value = "onCreate"  //activity是非活跃状态，不会回调onchange。 变为活跃时，value被onStart的value覆盖

        foreverObj = "forever"
        //mLiveData.observeForever(MyObserve())

    }


    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
        mLiveData.value = "onStart"  // 变为活跃状态，会回调onchange， 并且value会覆盖oncreate，onstop中设置的value
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
        mLiveData.value = "onResume"   //活跃状态，回调onChanged
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
        mLiveData.value = "onPause"   //活跃状态，回调onChanged
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
        mLiveData.value = "onStop"  //activity是非活跃状态， 不会回调onchange。 变为活跃时，value被onStart的value覆盖
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
        mLiveData.value = "onDestroy"  //非活跃状态，且此时Observer已被移除，不会回调onChanged
    }


    class MyObserver : Observer<String> {

        override fun onChanged(t: String?) {
            Log.i("observeForever", t ?: "")
        }

    }


    fun coroutineClick(view: View) {
        startActivity(Intent(this, CoroutineMainActivity::class.java))
    }


}