package com.advance.executor

import java.util.concurrent.Executors

/**
 *
 * 二 有界线程池（Executors.newFixedThreadPool(n)）
 *
 *
 * 释义：
 * 线程池在应用的声明周期内保持相同数量的线程，
 * 新任务提交时，如果线程池超过数值，将会被放入队列中等待执行
 *
 *
 * 优点：
 * 控制资源使用，防止线程数量无限增长，避免资源耗尽，系统稳定
 *
 * 缺点：
 * 灵活性差，负载大线程不足，负载小浪费资源
 * 不适用瞬时高并发
 * 可能导致线程饥饿，部分任务一直等待执行，产生线程饥饿情况
 *
 */


class FixedThreadPoolDemo {

    fun test() {
        val executorService = Executors.newFixedThreadPool(3)

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
    val fixedThreadPoolDemo = FixedThreadPoolDemo()
    fixedThreadPoolDemo.test()
}