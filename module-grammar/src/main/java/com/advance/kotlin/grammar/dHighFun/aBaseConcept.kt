package com.advance.kotlin.grammar.dHighFun

import com.advance.kotlin.grammar.bStructure.hello
import kotlin.reflect.jvm.reflect

/**
 * 高阶函数  把函数当成引用
 * 用函数的类型(如：（Int,Int）-> Int) 来限定传入的参数类型
 *
 *
 * @author xugang
 * @date 2021/5/9
 * @since
 */
fun main(args: Array<String>) {
    // 局部函数
    fun inner2IntArgsFun(a: Int, b: Int): String {
        return (a + b).toString()
    }

    /**
     * kotlin 中的函数类型,我理解为这是函数类型对象class，所以他才可以声明为变量
     *
     */
    // twoIntArgsFunReceiver：声明为 (Int, Int) -> String 这种类型Class的实例
    // 所以既然是class 肯定是不具名的,即(a：Int，b:Int)。同lambda的区别
    val twoIntArgsFunReceiver: (Int, Int) -> String

    // ::inner2IntArgsFun  并不是指向函数本身, 而是系统创建了(Int, Int) -> String 这种函数类型class的一个实例
    // 并且这个实例对象复制了原函数的功能，但它并不是原函数
    twoIntArgsFunReceiver = ::inner2IntArgsFun // 同一个类内，所以不用指定是哪个类里的函数了
    // 函数类型的实例的具体调用
    println(twoIntArgsFunReceiver(2, 4))
    println(twoIntArgsFunReceiver.invoke(2, 3))


    // 拿到Hello里world()函数类型的一个实例 不在同一类体内要加类名指定
    /**
     * 是不是有点像java的反射  获取Method的实例(只不过在kotlin中是FunctionX)
     */
    val helloWorld = Hello::world // val helloWorld: KFunction1<Hello, Int>
    val hello = Hello()
    helloWorld.invoke(hello) // 要传递一个实体对象


    // public inline fun <T> Array<out T>.filter(predicate: (T) -> Boolean): List<T>
    // public inline fun CharSequence.isNotEmpty(): Boolean
    args.filter(String::isNotEmpty) // 无需指定实例，就是当前调用者 todo release


    // print(message: Any?) : Unit
    // public inline fun ShortArray.forEach(action: (Short) -> Unit): Unit
    // Any 是包含Short的
    args.forEach(::print) // 这里就很好理解了  我们使用println()的时候 是不是也没有生命对象去调用他


    //args.forEach(PdfPrinter::print) // 需要指定具体实例
    args.forEach(PdfPrinter::printStatic) // 伴生 无需对象
    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::print)

}

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
    fun world(): Int {
        println("hello world")
        return 1
    }
}