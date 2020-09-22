package com.advance.kotlin.grammar.bStructure

/**
 * @author xugang
 * @date 2020/8/10
 * @since
 */
// 相当于 java 中的 final 常量

// 运行时常量 val x = getX() // 编译时并不知道

// 编译其常量 const 来修饰 编译时就已经知道值了
const val FINAL_HELLO_WORLD: String = "Hello World"
var helloWorld: String = "hello World"

// 类型推导
val FINAL_HELLO_CHINA = "hello china"

fun main(args: Array<String>) {
    helloWorld = "hello china"
    println(FINAL_HELLO_CHINA)
}
