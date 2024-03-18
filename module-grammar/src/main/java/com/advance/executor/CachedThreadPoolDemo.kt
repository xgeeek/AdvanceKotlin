package com.advance.executor

import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory


/**
 *
 * 一、缓存线程池(无界线程池)   Executors.newCachedThreadPool()
 *
 * 释义：
 * 用于创建一个根据需要创建新线程的线程池
 * 执行任务之前会尝试重用现有的空闲线程
 * 如果没有可用的线程，则会创建新的线程
 * 线程60s内没有使用，将被终止从缓存中移除
 *
 * 优点：
 * 动态调整线程数量，线程池能够灵活的适应工作负载的变化
 * 任务处理速度亏啊，线程池在瞬时负载较高的情况下能够更快的响应任务
 *
 * 缺点：
 * 可能导致资源耗尽，大量任务提交时，可能会创建大量线程，导致系统资源耗尽
 * 过度竞争，高并发情况下，大量线程之间竞争，影响性能
 * 任务堆积，如果执行时间长的任务，导致线程池中累积大量未完的任务，影响系统稳定性
 * 不适用于长期运行的任务
 *
 *
 * 使用场景：
 * 适用于任务短暂、处理速度快的场景
 *
 */
class CachedThreadPoolDemo {

    fun test() {
        val executorService = Executors.newCachedThreadPool()
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

    fun testThreadFactory() {
        // 创建自定义线程工厂
        val threadFactory =
            ThreadFactory { runnable ->
                val thread = Thread(runnable)
                thread.name = "CustomThread-" + thread.id
                thread.priority = Thread.NORM_PRIORITY
                thread.isDaemon = false
                thread
            }

        // 创建一个根据需要创建新线程的缓存线程池，使用自定义线程工厂
        val executorService = Executors.newCachedThreadPool(threadFactory)

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
    val cachedThreadPoolDemo = CachedThreadPoolDemo()
    cachedThreadPoolDemo.test()
    cachedThreadPoolDemo.testThreadFactory()
}