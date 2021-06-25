package com.advance.kotlin.grammar.dHighFun

/**
 * @author xugang
 * @date 2021/5/24
 */
fun main(args: Array<String>) {
    val threadLocalOne = ThreadLocal<String>()
    val threadLocalTwo = ThreadLocal<String>()

    Thread {
        threadLocalOne.set("线程一的数据 --- threadLocalOne")
        threadLocalTwo.set("线程一的数据 --- threadLocalTwo")
        println(threadLocalOne.get())
        println(threadLocalTwo.get())
    }.start()

    Thread {
        println(threadLocalOne.get())
        println(threadLocalTwo.get())
        threadLocalOne.set("线程二的数据 --- threadLocalOne")
        threadLocalTwo.set("线程二的数据 --- threadLocalTwo")
        println(threadLocalOne.get())
        println(threadLocalTwo.get())
    }.start()
}