package xxjg.learn.coroutines.juejin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author xugang
 * @date 2023/3/16
 */
private fun log(msg: Any?) = println("[${Thread.currentThread().name}] $msg")


fun main(args: Array<String>) {
    log("start")
    GlobalScope.launch(context = Dispatchers.IO) {
        launch {
            delay(400)
            log("launch A")
        }

        launch {
            delay(300)
            log("launch B")
        }
        log("GlobalScope")
    }
    log("end")
    Thread.sleep(500)
}