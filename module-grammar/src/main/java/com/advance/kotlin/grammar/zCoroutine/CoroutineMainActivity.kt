package com.advance.kotlin.grammar.zCoroutine

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.advance.kotlin.grammar.R
import com.advance.kotlin.grammar.example.ui.LoginActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author xugang
 * @date 2021/6/25
 */
class CoroutineMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
    }

    fun coroutineClick(view: View) {
        coroutineTest();
    }

    private fun coroutineTest() {
        // GlobalScope 应用程序生命周期内
        val runBlocking = runBlocking {
            Log.d("runBlocking", "启动一个协程")
        }
        Log.d("runBlockingJob", "$runBlocking")

        val launch = GlobalScope.launch {
            Log.d("launch", "启动一个协程")
        }
        Log.d("runBlockingJob", "$launch")

        val async = GlobalScope.async {
            Log.d("async", "启动一个协程")
        }
        Log.d("runBlockingJob", "$async")


        startActivity(Intent(this, LoginActivity::class.java))
    }
}