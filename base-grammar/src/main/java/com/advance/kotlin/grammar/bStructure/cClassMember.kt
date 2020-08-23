package com.advance.kotlin.grammar.bStructure

/**
 * 类成员
 * @author xugang
 * @date 2020/8/16
 * @since
 */
class X

class A {
    // 给默认初始值
    var b = 0

    // val 可以用 lazy 延迟初始化 必须有个返回值
    // 调用时才会执行
    val d: X by lazy {
        println("init X")
        X()
    }

    // var 可以用 lateinit 延迟初始化
    lateinit var c: String
}

fun main(args: Array<String>) {
    var a:A = A()
    println(a.b)
    // 第一次使用的时候 会调用 lazy 里的语句
    println(a.d)
    println(a.d)
}