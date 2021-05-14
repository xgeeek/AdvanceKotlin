package com.advance.kotlin.grammar.dHighFun

class PdfPrinter {
    companion object {
        fun printStatic(any: Any?) {
        }
    }

    fun print(any: Any?) { // KFunction2<PdfPrinter, Any?, Unit>
        kotlin.io.print(any)
    }
}

class Hello {
    fun world1(world: String): Int {
        return world.toInt()
    }
}


/**
 * 函数类型
 * 函数升级为对象，联想到java中反射的Method类
 * 高阶函数：用函数类型(如：（Int,Int）-> Int) 来限定传入的函数型参数的类型
 */
class FunctionClassType {

    // 普通函数
    private fun inner2IntArgsFun(a: Int, b: Int): String {
        return (a + b).toString()
    }

    fun main(args: Array<String>) {
        /**
         * 1.1 函数类型
         * 常量twoIntArgsFun 声明为(Int, Int) -> String这种函数类型的类型
         */
        val twoIntArgsFun: (Int, Int) -> String

        /**
         * 1.2. ::inner2IntArgsFun
         * 并不是指向函数本身, 而是系统创建了(Int, Int) -> String 这种函数类型class的一个实例
         * 并且这个实例对象复制了原函数的功能，但它并不是原函数
         */
        twoIntArgsFun = ::inner2IntArgsFun

        /**
         * 1.3. 函数类型对象的调用
         *    1.直接xxx()  2.xxx.invoke()
         */
        println(twoIntArgsFun(2, 4))
        println(twoIntArgsFun.invoke(2, 3))


        /**
         * 2.::xxx 加深理解
         */
        val helloWorld1 = Hello::world1
        val hello = Hello()
        helloWorld1.invoke(hello, "222") // 要传递一个实体对象
        println(helloWorld1)

        // print(message: Any?) : Unit
        // public inline fun ShortArray.forEach(action: (Short) -> Unit): Unit
        // Any 是包含Short的
        args.forEach(::print) // 这里就很好理解了  我们使用println()的时候 是不是也没有声明对象去调用他

        // public inline fun <T> Array<out T>.filter(predicate: (T) -> Boolean): List<T>
        // public inline fun CharSequence.isNotEmpty(): Boolean
        args.filter(String::isNotEmpty) // 无需指定实例，就是当前调用者 todo release

        val pdfPrinter = PdfPrinter()
        args.forEach(pdfPrinter::print) // (T) -> Unit
        args.forEach(PdfPrinter::printStatic) // 伴生里的函数，并不归属该类型的具体实例的，是共有的。所以无需对象
    }
}


/**
 * lambda 表达式的本质其实是匿名函数，底层还是通过匿名函数来实现的
 * 特点： Lambda表达式总是被大括号括着
 *       其参数(如果存在)在符号'->'之前声明(参数类型可以省略)
 *       函数体(如果存在)在符号'->'后面。
 */
class FunctionLambdaType {

    fun noArgFun(): Int {
        return 2
    }

    fun twoArgFun(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 1. 无参数的情况
     * val/var 变量名 = {...}
     */
    val noArgFunLambda = {
        2
    }


    /**
     * 2. 有参数的情况
     *
     * val/var 变量名 ：(参数类型，参数类型) -> 返回值类型 = {参数名，参数名 -> 方法体。。。}
     * (参数类型，参数类型) -> 返回值类型  可以看出来这里就是上面所说的函数类型
     *
     * 简写形式
     * val/var 变量名 = {参数名: 参数类型，参数名：参数类型  ->  方法体。。。}
     * lambda 默认方法体的最后一行为返回值，所以简写的方式是可以推断出返回值类型的
     */
    private val twoArgFunLambda: (Int, Int) -> Int = { a, b -> a + b }
    private val twoArgFunLambdaSimple = { a: Int, b: Int -> a + b }


    /**
     * 3. lambda 作为参数的情况
     * 例如：fun test(a : Int, 参数名 : (参数1 ： 类型，参数2 : 类型, ... ) -> 表达式返回类型){ ... }
     * 可以看到，是有写参数名的，与方法类型作为参数的不同之处
     */
    private fun lambdaArgFun(a: Int, b: Int, c: (x: Int, y: Int) -> Int): Int {
        return a + b + c.invoke(2, 3)  // 好像没多大意义,无法传递参数
    }


    /**
     * 4. lambda 作为函数体的情况
     */
    private fun lambdaBodyFun(x: Int, y: Int) = { a: Int, b: Int ->
        x + y + a - b
    }

    /**
     * 5. 闭包和it 的理解
     */
    fun lambdaIt(num1: Int, bool: (Int) -> Boolean): Int {
        return if (bool(num1)) {
            num1
        } else
            0
    }

    fun testIt() {
        // 传入此函数类型的  lambda表达式（大括号内部分 即闭包）
        lambdaIt(2, { int: Int -> int > 7 }) // 完整闭包
        lambdaIt(2, { int -> int > 7 })      // 返回值类型省略的闭包
        lambdaIt(2) { int -> int > 7 }       // 当lambda闭包是函数的最后一个参数时，可以再调用时将lambda闭包体移到()外
        lambdaIt(2) { it > 7 }               // 当lambda闭包只有一个参数时，可以用it来替代  it---Int----num1
    }


    /**
     * 6._ 下划线  在使用Lambda表达式的时候，可以用下划线(_)表示未使用的参数，表示不处理这个参数
     */
    fun testMap() {
        val map = mapOf("key1" to "value1", "key2" to "value2")
        map.forEach { (_, value) -> println("$value") }
    }


    fun main(args: Array<String>) {
        // 无参数
        // 从lambda 的调用方式可以看出同函数类型调用相同
        println(noArgFunLambda) // () -> kotlin.Int
        println(noArgFunLambda()) // 2
        println(noArgFunLambda.invoke()) // 2

        // 有参数
        println(twoArgFunLambda)  // (kotlin.Int, kotlin.Int) -> kotlin.Int
        println(twoArgFunLambdaSimple)
        println(twoArgFunLambda.invoke(2, 8))

        // 作为参数
        println(lambdaArgFun(3, 2, twoArgFunLambda)) //10

        // 作为函数体
        println(lambdaBodyFun(2, 3)) // (kotlin.Int, kotlin.Int) -> kotlin.Int  可以看出是函数类型
        println(lambdaBodyFun(2, 3).invoke(3, 4)) //2+3+3-4 = 4

        // it
        testIt()
        val arr = arrayOf(1, 5, 7, 9, 10)
        // filter(predicate: (T) -> Boolean)  it----String----args里的值
        println(arr.filter() { it < 5 }.component1()) // 1 filter方法的()省略掉了 因为没有参数

    }

}


fun main(args: Array<String>) {
    FunctionClassType().main(args)
    FunctionLambdaType().main(args)
}
