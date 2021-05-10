package com.advance.kotlin.grammar.dHighFun

import com.advance.kotlin.grammar.bStructure.hello

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

    // 在理解一下函数类型
    val my2IntArgsFun: (Int, Int) -> String
    // 将my2IntArgsFun 的引用 赋值给inner2IntArgsFun （二者的函数类型一致）
    // 这里是函数的引用 所以不在是函数调用的方式 xxx()
    // 而是 ::xxx
    my2IntArgsFun = ::inner2IntArgsFun // 同一个闭包内 直接引用
    // 引用的调用
    print(my2IntArgsFun.invoke(2, 3)) // 不用传递实体对象 因为在同一个闭包内


    // 拿到函数的引用 不在同一包体内要加类名
    val helloWorld = Hello::world
    // 调用函数
    val hello = Hello()
    helloWorld.invoke(hello) // 要传递一个实体对象


    // public inline fun <T> Array<out T>.filter(predicate: (T) -> Boolean): List<T>
    // public inline fun CharSequence.isNotEmpty(): Boolean
    args.filter(String::isNotEmpty) // 无需指定实例，就是当前调用者 todo release


    // print(message: Any?) : Unit
    // public inline fun ShortArray.forEach(action: (Short) -> Unit): Unit
    // Any 是包含Short的
    args.forEach(::print) // 包级别函数 todo release


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
    fun world() {
        print("hello world")
    }
}