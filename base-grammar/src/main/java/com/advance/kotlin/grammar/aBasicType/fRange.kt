package com.advance.kotlin.grammar.aBasicType

/**
 * 区间
 * @author xugang on 2019/11/5
 */
val range: IntRange = 0..1024 // [0,1024]
val range_exclusive: IntRange = 0 until 1024 // [0,1024)

val range_empty = 0..-1

fun main() {
    println(range_empty.isEmpty())

    // 是否在当前这个区间中
    println(range.contains(50))
    println(50 in range)

    for (i in range_exclusive) {
        println("$i ,")
    }
}