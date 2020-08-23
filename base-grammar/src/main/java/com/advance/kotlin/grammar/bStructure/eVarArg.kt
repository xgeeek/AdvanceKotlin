package com.advance.kotlin.grammar.bStructure

/**
 * 具名参数/可变参数/默认值
 * @author xugang
 * @date 2020/8/23
 * @since
 */
fun main(args: Array<String>) {
    // java 中的变长参数只能放在最后一位
    // kotlin 中是具名的
    val list = arrayListOf<Int>(1, 3, 4, 5)
    val array = intArrayOf(1, 3, 4, 5)

    // 具名参数 因为第一个参数没传 所以后面要使用具名参数
    hello(ints = *array, string = "hello args")
    // 如果是最后一个可以不传
    hello(3.0, *array)
}

fun hello(double: Double = 3.0, vararg ints: Int, string: String = "hello") {
    ints.forEach(::println)
    println(string)
}