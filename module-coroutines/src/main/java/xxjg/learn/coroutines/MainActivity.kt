package xxjg.learn.coroutines

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author xugang
 * @date 2022/4/1
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_main)
    }


    fun coroutineClick(view: View) {
        // 阻塞线程
        val runBlockingJob = runBlocking {
            Log.d("runBlocking", "启动一个协程")
            41
        }
        Log.d("runBlockingJob", "$runBlockingJob")

        // Job
        val launchJob = GlobalScope.launch {
            Log.d("launch", "启动一个协程")
        }
        Log.d("launchJob", "$launchJob")

        // Deferred
        val asyncJob = GlobalScope.async {
            Log.d("async", "启动一个协程")
            "我是返回值"
        }
        Log.d("asyncJob", "$asyncJob")
    }
}