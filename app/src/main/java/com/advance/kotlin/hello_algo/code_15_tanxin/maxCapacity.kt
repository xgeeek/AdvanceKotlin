package com.advance.kotlin.hello_algo.code_15_tanxin

import kotlin.math.max
import kotlin.math.min

/**
 *
 * 输入一个数组 ht，其中的每个元素代表一个垂直隔板的高度。数组中的任意两个隔板，以及它们之间的空间可以组成一个容器。
 *
 * 容器的容量等于高度和宽度的乘积（面积），其中高度由较短的隔板决定，宽度是两个隔板的数组索引之差。
 *
 * 请在数组中选择两个隔板，使得组成的容器的容量最大，返回最大容量。
 *
 * @author xugang
 * @date 2024/10/22
 */

fun maxCapacity(ht: IntArray): Int {
    var i = 0 // 头
    var j = ht.size - 1 // 尾

    var res = 0
    // 循环贪心选择，直至两板相遇
    while (i < j) {
        val cap = min(ht[i], ht[j]) * (j - i)
        res = max(res, cap)
        // 向内移动短板
        // 宽度变小 短板右移找长板才可能比当前大   如果长版左移，宽变小，新来的长还是小的短板决定，新来的短的只会更短，都会使得容积变小
        if (ht[i] < ht[j]) {
            i++
        } else {
            j--
        }
    }
    return res
}

fun main() {
    val ht = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(maxCapacity(ht))
}