package com.advance.executor

import java.util.concurrent.Executors

/**
 * 三 有界线程池 (Executors.newSingleThreadExecutor())
 *
 * 释义：
 * 一个包含单个线程的线程池。确保所有提交的任务按照顺序执行。
 *
 * 优点：
 * 顺序执行，对于需要按照特定顺序执行处理任务的场景非常有用，确保任务之间的顺序关系得到维护
 * 线程复用，单线程池中只有一个线程，该线程会被重复使用，减少开销，提高复用性
 * 异常管理，如果任务抛出异常导致线程终止，线程池会创建一个新的线程取代原线程，确保总有一个可用的线程，防止用用程序崩溃
 * 任务队列的管理，内部维护一个任务队列，将任务按照提交的顺序进行排队，有助于管理任务的执行顺序和并发度
 *
 */

class SingleThreadExecutorDemo {

    fun test() {
        val executorService = Executors.newSingleThreadExecutor()

        for (i in 0..5) {
            val taskId = i
            executorService.submit {
                println("Task $taskId" + " is executing by " + Thread.currentThread().name)
                try {
                    Thread.sleep(2000) // 模拟任务执行
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        executorService.shutdown()
    }
}


fun main() {
    val singleThreadExecutorDemo = SingleThreadExecutorDemo()
    singleThreadExecutorDemo.test()
}