package com.advance.kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.advance.kotlin.kline.demo.KDiagramActivity
import com.advance.kotlin.mmkv.MkvAdvanceUtils
import com.advance.kotlin.mmkv.MkvTableUtils
import com.advance.kotlin.mmkv.MkvUtils
import com.advance.kotlin.sort_dialog.ADialog
import com.advance.kotlin.sort_dialog.BDialog
import com.advance.kotlin.sort_dialog.CDialog
import com.advance.kotlin.sort_dialog.DialogChain
import com.kh.keyboard.KeyBoardDialogUtils
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.enums.SidePattern
import com.lzf.easyfloat.interfaces.OnTouchRangeListener
import com.lzf.easyfloat.utils.DragUtils
import com.lzf.easyfloat.widget.BaseSwitchView
import xxjg.learn.coroutines.MainActivity

class MainActivity : AppCompatActivity() {

    val TAG = "livedata"

    val mLiveData = MutableLiveData<String>()
    lateinit var foreverObj: String
    private lateinit var dialogChain: DialogChain
    private val bDialog by lazy { BDialog(this) }

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


        createDialogChain() //创建 DialogChain
        // 模拟延迟数据回调。
        Handler(Looper.getMainLooper()).postDelayed({
            bDialog.onDataCallback("延迟数据回来了！！")
        }, 5000)


        MkvUtils.clearAll()
        MkvAdvanceUtils.encode("new", "new advance555")
        val tvOne = findViewById<TextView>(R.id.tv_one)
        tvOne.text = MkvAdvanceUtils.decodeString("new").toString()

        MkvTableUtils.encode(
            "quote", "testtesttest"
        )

        val tvTwo = findViewById<TextView>(R.id.tv_two)
        tvTwo.text = MkvTableUtils.decodeString("quote").toString()


        val et: EditText = findViewById(R.id.et)
        val keyBoardDialogUtils = KeyBoardDialogUtils(this)
        et.setOnClickListener(View.OnClickListener { keyBoardDialogUtils.show(et) })
    }

    //创建 DialogChain
    private fun createDialogChain() {
        dialogChain = DialogChain.create(3)
            .attach(this)
            .addInterceptor(ADialog(this))
            .addInterceptor(bDialog)
            .addInterceptor(CDialog(this))
            .build()

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
        mLiveData.value = "onStart"  // 变为活跃状态，会回调onchange， 并且value会覆盖oncreate，onstop中设置的value

        // 开始从链头弹窗。
        dialogChain.process()
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
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun kLineClick(view: View) {
        //startActivity(Intent(this, KDiagramActivity::class.java))
        showAppFloat3("xx")
    }

    private fun showAppFloat3(tag: String) {
        EasyFloat.with(this.applicationContext)
            .setTag(tag)
            .setShowPattern(ShowPattern.ALL_TIME)
            .setSidePattern(SidePattern.RESULT_SIDE)
            .setImmersionStatusBar(true)
            .setGravity(Gravity.END, -20, 100)
            .setLayout(R.layout.layout_suspension_view) {

            }
            .registerCallback {
                drag { _, motionEvent ->
                    DragUtils.registerDragClose(motionEvent, object : OnTouchRangeListener {
                        override fun touchInRange(inRange: Boolean, view: BaseSwitchView) {
                            view.findViewById<TextView>(com.lzf.easyfloat.R.id.tv_delete).text =
                                if (inRange) "松手删除" else "删除浮窗"

                            view.findViewById<ImageView>(com.lzf.easyfloat.R.id.iv_delete)
                                .setImageResource(
                                    if (inRange) com.lzf.easyfloat.R.drawable.icon_delete_selected
                                    else com.lzf.easyfloat.R.drawable.icon_delete_normal
                                )
                        }

                        override fun touchUpInRange() {
                            EasyFloat.dismiss(tag)
                        }
                    }, showPattern = ShowPattern.ALL_TIME)
                }
            }
            .show()
    }


}