package com.advance.kotlin.grammar.aBasicType

/**
 * 类型转换
 * 一切皆对象
 * @author xugang
 * @date 2020/8/9
 * @since
 */
fun main(args: Array<String>) {
    var parent: Parent = Child()

    // 智能类型转换
    if (parent is Child) {
        println(parent.name)
    }

    val str: String? = "hello"
    //println(str.length) // 报错 可能为 null
    if (str is String) { // 转成非空类型
        println(str.length)
    }

    // 强制转换
    val parent1: Parent = Parent()
    // type mismatch 类型不匹配
    // val child: Child = parent1

    // as 强制转化
    val child2: Child = parent1 as Child
    println(child2) // 类型转换异常

    // 我们不想让其报异常怎么办
    // 类型安全的转换  as? 表示安全的转换 转换出错的时候返回 null
    // 所以前面接收的变量也要变为可空类型的
    val child3: Child? = parent1 as? Child
    println(child3)

}