package com.advance.kotlin.grammar.bStructure

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * 函数
 * 局部函数   函数方法体里定义函数
 * 匿名函数
 * @author xugang
 * @date 2020/8/10
 * @since
 */
// 返回值  参数默认值  sum(3) = 5
fun sum(arg1: Int, arg2: Int = 2): Int {
    return arg1 + arg2
}

// 函数体 简单的一个表达式 返回值类型自动推断
fun simpleSum(arg1: Int, arg2: Int) = arg1 + arg2

// 局部函数
fun outer() {
    fun inner() {
    }
}

// 匿名函数 要有赋值
val int2Long = fun(arg: Int): Long {
    return arg.toLong()
}

/**
 * open 可继承
 */
open class AnimBase {
    /**
     * open 可重写
     */
    open fun test(a: Int, b: Int = 1) {

    }
}

class AnimDoge : AnimBase() {

    /**
     * 重写方法  不允许为参数值指定默认值，无论 a , b 都不行
     */
    override fun test(a: Int, b: Int) {
        super.test(a, b)
    }
}



/**
 * 中缀表达式条件：
 * 是成员函数或者扩展函数
 * 拥有单个参数
 * 声明时使用 infix
 */
class Book {
    // infix 中缀表达式 只有一个参数
    infix fun on(any: Desk): Boolean {
        return any.isGoodBook
    }
}

class Desk {
    var isGoodBook: Boolean = false
}


// Unit 相当于 java 的 void
fun main(args: Array<String>): Unit {
    // 命名参数使用
    println(sum(arg1 = 2, arg2 = 3)) //5
    // 匿名函数
    println(int2Long(234))
    // 最多到 Function22
    println(int2Long) // 打印函数的定义  Function1<java.lang.Integer, java.lang.Long>


    // lambda 表达式在这里是个参数
    // 这个 return 是直接 return 的 main 函数
    // 下面语句不会在执行  所以加个 ForEach 标签 表示当前返回
    args.forEach ForEach@{
        if (it == "q")
            return@ForEach  // return 当前循环 相当于 Continue
        println(it)
    }
    println("the end")


    // on 是方法名
    if (Book() on Desk()) { // dsl

    }

}




