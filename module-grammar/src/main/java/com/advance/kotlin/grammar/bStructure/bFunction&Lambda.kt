package com.advance.kotlin.grammar.bStructure

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * 函数 lambda
 * 局部函数   函数方法体里定义函数
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


// 匿名函数 要有赋值
val int2Long = fun(arg: Int): Long {
    return arg.toLong()
}


/**
 * lambda 表达式的本质其实是匿名函数，底层还是通过匿名函数来实现的
 * 特点： Lambda表达式总是被大括号括着
 *       其参数(如果存在)在符号'->'之前声明(参数类型可以省略)
 *       函数体(如果存在)在符号'->'后面。
 */

// 1.无参数的情况  val/var 变量名 = {...}
fun test() {
    println("无参数")
}

// lambda
val testLambda = { println("无参数") }


// 2.有参数的情况  val/var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }
// 可等价于 即表达式的返回值类型会根据操作的代码自推导出来。
// val/var 变量名 = { 参数1 ： 类型，参数2 : 类型, ... -> 操作参数的代码 }
fun test(a: Int, b: Int): Int {
    return a + b
}

// lambda
val testArgsLambda: (Int, Int) -> Int = { a, b -> a + b }
// 可以看出 testArgsLambda 其实就是函数的引用   高阶函数中的将函数作为一个引用，使函数成为一等公民
// 且指定函数引用类型为 (Int, Int) -> Int 然后在赋值

// 简写
val testArgsLambdaSimple = { a: Int, b: Int -> a + b }
// 可以看出编译器 通过后面参数的类型 推断出了 testArgsLambdaSimple 函数引用的类型


// 3.lambda作为函数中的参数的时候
// 例如：fun test(a : Int, 参数名 : (参数1 ： 类型，参数2 : 类型, ... ) -> 表达式返回类型){ ... }
// 规定参数的 函数引用类型

fun sum2(a: Int, b: Int): Int {
    return a + b
}

// 普通调用
// test(10, sum2(2, 3))

// lambda
fun testLambdaArgs(a: Int, b: (num1: Int, num2: Int) -> Int): Int {
    return a + b(2, 6)
}


// 4.lambda作为函数体时
fun add(x: Int, y: Int) = { a: Int, b: Int ->
    x + y + a - b
}


// 5.it
fun testIt(num1: Int, bool: (Int) -> Boolean): Int {
    return if (bool(num1)) {
        num1
    } else
        0
}


// 6._ 下划线  在使用Lambda表达式的时候，可以用下划线(_)表示未使用的参数，表示不处理这个参数


// Unit 相当于 java 的 void
fun main(args: Array<String>): Unit {
    // 命名参数使用
    println(sum(arg1 = 2, arg2 = 3)) //5
    // 匿名函数
    println(int2Long(234))
    // 最多到 Function22
    println(int2Long) // 打印函数的定义  Function1<java.lang.Integer, java.lang.Long>

    // 1. lambda 无参数
    println(testLambda)     // () -> kotlin.Unit
    println(testLambda())

    // 2. lambda 有参数
    println(testArgsLambda)     // (kotlin.Int, kotlin.Int) -> kotlin.Int
    println(testArgsLambda(2, 4))   // 6
    println(testArgsLambdaSimple)   // (kotlin.Int, kotlin.Int) -> kotlin.Int
    println(testArgsLambdaSimple(2, 4)) // 6

    // 3. lambda 作为参数
    // 普通调用
    println(test(10, sum2(2, 3))) // 15
    // lambda  函数引用类型的具体实现
    println(testLambdaArgs(10, testArgsLambda))  // 18
    // 理解这里
    // Type mismatch.  Required: (Int, Int) → Int
    // Found: Int
    //println(testLambdaArgs(10, sum2(3, 4)))

    // 4. lambda 作为函数体
    println(add(2, 3).invoke(4, 5))  // 4

    // 5. lambda it 是在当一个高阶函数中Lambda表达式的参数只有一个的时候可以使用it来使用此参数。
    // it可表示为单个参数的隐式名称，是Kotlin语言约定的。
    val arr = arrayOf(1, 5, 7, 9, 10)
    println(arr.filter { it < 5 }.component1()) // 1
    println(testIt(5, { it > 3 })) // 5
    // 尾随闭包
    println(testIt(4) { it > 5 })  // 0

    // 6. _
    val map = mapOf("key1" to "value1", "key2" to "value2")
    map.forEach { (_, value) -> println("$value") }


//    for (i in args){
//        println(i)
//    }

    // （T）-> Unit
//    args.forEach {
//        println(it)
//    }

    // 完整写法  forEach()里是个 action
//    args.forEach ({element->
//        println(element)
//    })

    // 括号可以省略
//    args.forEach() {
//        println(it)
//    }

    // 参数一致
//    args.forEach(::println)

    // lambda 表达式在这里是个参数
    // 这个 return 是直接 return 的 main 函数
    // 下面语句不会在执行  所以加个 ForEach 标签 表示当前返回
    args.forEach ForEach@{
        if (it == "q")
            return@ForEach  // return 当前循环 相当于 Continue
        println(it)
    }
    println("the end")

    println(testLambda is () -> Unit) // 可以判断函数类型

}




