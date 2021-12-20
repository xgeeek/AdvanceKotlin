package com.advance.kotlin.grammar.dHighFun

import android.os.Bundle
import com.advance.kotlin.grammar.example.ui.BlankFragment
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * 作用域函数
 * 目的是在对象的上下文中执行代码块，它为调用者对象提供了一个临时内部作用域，在这个作用域中可以不显示的
 * 访问该对象。
 * @author xugang
 * @date 2021/5/11
 */

/**
 * run()、with()
 */
class RunWithFunClass {

    /**
     * 1.用作独立
     */
    private fun testRun1() {
        println(Thread.currentThread())
        val str = "kotlin"
        kotlin.run {
            println(Thread.currentThread())
            val str = "kotlin run"
            println(str)
        }
        println(str)
    }


    /**
     * 2.需要执行同一段代码而根据不同的条件得到不同的结果
     */
    private fun testRun2() {
        val index = 3
        val num = kotlin.run {
            when (index) {
                0 -> "kotlin"
                1 -> "java"
                2 -> "php"
                3 -> "javaScript"
                else -> "none"
            }
        }.length
        println(num)
    }


    /**
     * 3. T.run() 需要使用当前对象的上下文的时候
     * public inline fun <T, R> T.run(block: T.() -> R): R
     */
    private fun testRun3() {
        val str: String? = "kotlin"
        str?.run {
            println(str.length)
        }

        // 例如
        // val tvSure = findViewById()
        // tvSure.run {
        //      text = "kotlin"
        //      textSize = 13f
        // }
    }


    /**
     * 4. with()
     * 同T.run()函数作用函数  只是一个是扩展函数，一个是普通成员函数
     *  public inline fun <T, R> with(receiver: T, block: T.() -> R): R
     */
    private fun testRun4() {
        val str: String? = "kotlin"
        with(str) {
            println(str?.length)
        }
    }


    fun main(args: Array<String>) {
        testRun1()
        testRun2()
        testRun3()
        testRun4()
    }
}


/**
 *
 * 作用域函数	Object reference	Return value
 *  run     	this	              Lambda result
 *  with	    this	              Lambda result
 *  apply	    this	              上下文对象
 *  let	        it	                  Lambda result
 *  also	    it	                 上下文对象
 *
 *

 *  1. T.run()  返回值：lambda的返回值   lambda表达式访问上下文对象方式： this    T.
 *  public inline fun <T, R> T.run(block: T.() -> R): R {
 *      return block()
 *   }
 *
 *  2. with()  返回值：lambda的返回值   lambda表达式访问上下文对象方式： this   T.
 *   public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
 *       return receiver.block()
 *   }
 *
 *  3. T.let() 返回值：lambda的返回值   lambda表达式访问上下文对象方式：it    (T)
 *  public inline fun <T, R> T.let(block: (T) -> R): R {
 *      return block(this)
 *  }
 *
 *  4. also()  返回值：上下文对象    lambda表达式访问上下文对象方式：it      (T)
 *  public inline fun <T> T.also(block: (T) -> Unit): T {
 *      block(this)
 *      return this
 * }
 *
 *  5. apply()  返回值：上下文对象    lambda表达式访问上下文对象方式：this    T.
 *   public inline fun <T> T.apply(block: T.() -> Unit): T {
 *      block()
 *      return this
 *  }
 *
 */


/**
 *   用于初始化对象或更改对象属性，可使用apply
 *   如果将数据指派给接收对象的属性之前验证对象，可使用also
 *   如果将对象进行空检查并访问或修改其属性，可使用let
 *   如果是非null的对象并且当函数块中不需要返回值时，可使用with
 *   如果想要计算某个值，或者限制多个本地变量的范围，则使用run
 */


/**
 * apply()、also()、let()
 */
class ApplyAlsoLetFunClass {

    companion object {
        fun testLet() {
            val str = "kotlinlet"
            str.let {// 返回的是lambda的值
                println("kotlinlet 中的 this：$this") // companion
                println("原字符串：$it")         // kotlinlet
                it.reversed()
            }
        }
    }

    private fun testFun() {
        val str = "kotlin"

        str.run {
            println("run 中的 this：$this")    // kotlin
            println("原字符串：$this")         // kotlin
            this.reversed()   // 返回值是最后一行
        }.run {
            println("反转字符串后的值：$this")     // niltok
            this.plus("-java")
        }.run {
            println("新的字符串：$this")          // niltok-java
        }

        with(with(str) {
            println("with 内部中的 this：$this") // kotlin
            this.reversed()
        }) {
            println("with 外部中的 this：$this") // niltok
        }

        val applyFun = { aa: String ->
            println("apply 中的 this：$this")    // ApplyAlsoLetFunClass
            aa.reversed()
            println("apply 中的 this2：$this")    // ApplyAlsoLetFunClass
        }

        str.apply(applyFun).apply {
            println("反转字符串后的值：$this")     // kotlin
            this.plus("-java")
        }.apply {
            println("新的字符串：$this")        // kotlin
        }


        val letFun = { a: String ->
            println("let 中的 this：$this") // ApplyAlsoLetFunClass
            println("原字符串：$a")         // kotlin
            a.reversed()
        }
        str.let(letFun)

        str.let {
            println("let 中的 this：$this") // ApplyAlsoLetFunClass
            println("原字符串：$it")         // kotlin
            it.reversed()
        }.let {
            println("反转字符串后的值：$it")     // niltok
            it.plus("-java")
        }.let {
            println("新的字符串：$it")          // niltok-java
        }

        str.also {
            println("also 中的 it：$it")       // kotlin
            println("also 中的 this：$this")   // ApplyAlsoLetFunClass
            it.reversed()
        }.also {
            println("反转字符串后的值：$it")     // kotlin
            it.plus("-java")
        }.also {
            println("新的字符串：$it")        // kotlin
        }


    }

    fun main(args: Array<String>) {
        testFun()
    }

}


fun main(args: Array<String>) {
    RunWithFunClass().main(args)
    //ApplyAlsoLetFunClass.testLet()
    ApplyAlsoLetFunClass().main(args)

    // let
//    val numbers = mutableListOf("one", "two", "three", "four", "five")
//    numbers.map {
//        it.length
//    }.filter {
//        it > 3
//    }.let { singleLength ->
//        print("执行了1次哦")
//        print(singleLength)
//    }
}