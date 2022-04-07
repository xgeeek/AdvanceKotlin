package com.advance.kotlin.grammar.aBasicType

/**
 * 基础数据类型
 * @author xugang
 * @date 2020/8/8
 * @since 1.0
 */

// 注意书写的格式
/**
 * Boolean 事物的对立面性，皆可 boolean 表示。
 */
val aBoolean: Boolean = true

/**
 * Int 不存在拆封装箱
 */
val aInt: Int = 1;
val bInt: Int = 0xff
val cInt: Int = 0b00000011
val maxInt: Int = Int.MAX_VALUE
val minInt: Int = Int.MIN_VALUE

/**
 * Long 书写时 L 最好是保留的
 */
val aLong: Long = 123456789L

/**
 * 使用下划线 使数字更容易读 since 1.1
 */
val oneMillion = 1_000_000

/**
 * Float 精度不准确
 */
val aFloat: Float = 1.0f
val bFloat: Float = 1E3f

/**
 * Double
 */
val aDouble: Double = 100.0

/**
 * Short
 */
val aShort: Short = Short.MAX_VALUE

/**
 * Byte
 */
val aByte: Byte = Byte.MAX_VALUE

/**
 * 隐士转换
 */
val along = aInt.toLong()

/**
 * 字符  2个字节
 */
val aChar: Char = 'c'
val bChar: Char = '中'

/**
 * 字符串
 */
val aStr: String = "HelloWorld"
val fromChars: String = String(charArrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'))
val rawStr: String = """ wode
    hhhhh
    
    \t
    dkja
    """


fun main(args: Array<String>) {
    println(bFloat)

    // pow 表示平方的意思
    println(Math.pow(10.0, 4.0))
    // NaN  not a number
    println(0.0f / 0f == Float.NaN) // false

    println(aShort)
    println(aByte)

    // == 相当于equals
    println(aStr == fromChars) // true
    // 比较的两个对象是否是同一个
    println(aStr === fromChars) // false
    // 字符串模板  $ 引用
    println("$aInt+$bInt=${aInt + bInt}")

}