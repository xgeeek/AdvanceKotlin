package com.advance.kotlin.grammar.dHighFun

import com.advance.kotlin.grammar.bStructure.hello

/**
 * 高阶函数  把函数当成引用
 *
 *
 * @author xugang
 * @date 2021/5/9
 * @since
 */
fun main(args: Array<String>) {
    // 注意写法 没有括号
    args.forEach(::print)

    // 拿到函数的引用
    val helloWorld = Hello::world
    // 调用函数
    val hello = Hello()
    helloWorld.invoke(hello)

    // 函数签名一致
    args.filter(String::isNotEmpty)

    // 参数不一致 无法引用
    //args.forEach(PdfPrinter::print)

    // 第一个函数是当前实例
    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::print)

}

class PdfPrinter {
    fun print(any: Any) {
        kotlin.io.print(any)

    }
}


class Hello {
    fun world() {
        print("hello world")
    }
}