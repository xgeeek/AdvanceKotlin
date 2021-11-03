package com.advance.kotlin.grammar.bStructure

/**
 * 类成员
 * @author xugang
 * @date 2020/8/16
 * @since
 */
class X

class A {
    // 给默认初始值
    var b = 0

    // val 可以用 lazy 延迟初始化 必须有个返回值
    // 调用时才会执行
    val d: X by lazy {
        println("init X")
        X()
    }

    // var 可以用 lateinit 延迟初始化
    lateinit var c: String

    // 具体细节：
    // 属性声明为非空类型必须在构造函数中初始化，这样非常不方便。
    // 例如：属性可以通过依赖注入来初始化，或者在单元测试的setup方法初始化。这种情况下，你不能在构造函数中提供一个非空初始器。
    // 但你仍想在类体中引用该属性时避免空检测

    // 该修饰符只能用于在类体中的属性（不是在主构造函数中声明的 var 属性，并且仅当该属性没有自定义 getter 或 setter 时），
    // 而自 Kotlin 1.2 起，也用于顶层属性与局部变量。该属性或变量必须为非空类型，并且不能是原生类型。
    // 在初始化前访问一个 lateinit 属性会抛出一个特定异常，该异常明确标识该属性被访问及它没有初始化的事实。

    private var source: Int = -1 // 非空有初始值
    private var searchResultList: MutableList<String>? = null  // 可空且初始值为空
    private lateinit var resultAdapter: String   // 非空未初始化   lateinit 使用的场景是 var(变量)
    private val binding by lazy { initBinding() } // 第一次使用时会执行  lazy 使用的场景是 val(常量)
    private val hehe: String  // 非空但在构造器中初始化了
    private val haha: Int     // 非空但在初始化块中初始化了

    init {
        haha = -1
    }

    constructor() {
        hehe = ""
    }

    private fun initBinding(): X {
        return X()
    }

}

fun main(args: Array<String>) {
    var a: A = A()
    println(a.b)
    // 第一次使用的时候 会调用 lazy 里的语句
    println(a.d)
    println(a.d)
}