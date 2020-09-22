package com.advance.kotlin.grammar.aBasicType

/**
 * 数组
 * @author xugang on 2019/11/5
 */
// 定制版的Array
val arrayOfInt: IntArray = intArrayOf(1, 3, 5, 7)
val arrayOfChar: CharArray = charArrayOf('H', 'e', 'l', 'l', 'o')
// 普通版的Array
val arrayOfString: Array<String> = arrayOf("我", "是", "码农")


fun main(args: Array<String>) {
    // 大小
    println(arrayOfInt.size)
    // 遍历
    for (int in arrayOfInt) {
        println(int)
    }
    // 定位
    println(arrayOfString[2])
    // 小技巧
    println(arrayOfChar)
    // 拼接
    println(arrayOfChar.joinToString(""))
    // 数组切片 字符串也支持切片的
    println(arrayOfInt.slice(1..2))
}


