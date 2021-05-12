package com.advance.kotlin.grammar.dHighFun

import com.advance.kotlin.grammar.bStructure.sum

/**
 * 常用高阶函数
 * @author xugang
 * @date 2021/5/11
 */

fun main(args: Array<String>) {
    // lambda 再理解
    val sumLambda = { a: Int, b: Int -> a + b }
    var numFun: (a: Int, b: Int) -> Int

    numFun = ::sum
    numFun.invoke(2, 3)

    //1.函数作为参数
    val testStr = "abcd"

    val testArgsLambda: (Char) -> Int = { b -> b.toInt() } //完整lambda表达式
    val testArgsLambdaSimple = { a: Char -> a.toInt() }  // 简写lambda表达式
    testStr.sumBy(testArgsLambda)
    testStr.sumBy(testArgsLambdaSimple)

    testStr.sumBy { a -> //尾随闭包
        a.toInt()
    }
    testStr.sumBy { // 一个参数省略
        it.toInt()
    }
}