package com.advance.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.advance.kotlin.adapter.MainAdapter
import com.advance.kotlin.bean.JumpItemBean
import com.advance.kotlin.bean.JumpItemChildBean
import com.advance.kotlin.mmkv.MkvAdvanceUtils
import com.advance.kotlin.mmkv.MkvTableUtils
import com.advance.kotlin.mmkv.MkvUtils

class MainActivity : AppCompatActivity() {

    val TAG = "livedata"

    val mLiveData = MutableLiveData<String>()
    lateinit var foreverObj: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainList = mutableListOf<JumpItemBean>().apply {
            add(JumpItemBean("弹窗", mutableListOf<JumpItemChildBean>().apply {
                add(JumpItemChildBean("Dialog链式调用"))
                add(JumpItemChildBean("悬浮窗"))
            }, true))
            add(JumpItemBean("WebView", mutableListOf<JumpItemChildBean>().apply {
                add(JumpItemChildBean("网页视频全屏播放"))
                add(JumpItemChildBean("WebView in scrollView"))
            }, false))
            add(JumpItemBean("Fragment", mutableListOf<JumpItemChildBean>().apply {
                add(JumpItemChildBean("可见性监听"))
            }, false))
            add(JumpItemBean("Canvas", mutableListOf<JumpItemChildBean>().apply {
                add(JumpItemChildBean("clipPath"))
            }, false))
            add(JumpItemBean("常见效果", mutableListOf<JumpItemChildBean>().apply {
                add(JumpItemChildBean("顶部小楼"))
                add(JumpItemChildBean("期货列表"))
                add(JumpItemChildBean("SeekBar"))
                add(JumpItemChildBean("跑马灯"))
                /*add(JumpItemChildBean("KChart"))*/
            }, false))
        }

        findViewById<RecyclerView>(R.id.rv_main).apply {
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            val mainAdapter = MainAdapter()
            this.adapter = mainAdapter
            mainAdapter.setNewData(mainList)
        }


        mLiveData.observe(this, {
            Log.i(TAG, "onchanged: $it")
        })
        Log.i(TAG, "onCreate")
        mLiveData.value = "onCreate"  //activity是非活跃状态，不会回调onchange。 变为活跃时，value被onStart的value覆盖

        foreverObj = "forever"
        //mLiveData.observeForever(MyObserve())


        MkvUtils.clearAll()
        MkvAdvanceUtils.encode("new", "new advance555")
        MkvAdvanceUtils.decodeString("new").toString()
        MkvTableUtils.encode(
            "quote", "testtesttest"
        )

//        val et: EditText = findViewById(R.id.et)
//        val keyBoardDialogUtils = KeyBoardDialogUtils(this)
//        et.setOnClickListener(View.OnClickListener { keyBoardDialogUtils.show(et) })
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

}