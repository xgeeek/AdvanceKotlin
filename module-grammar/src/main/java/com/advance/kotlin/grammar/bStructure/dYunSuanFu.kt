package com.advance.kotlin.grammar.bStructure

/**
 * 运算符
 * @author xugang
 * @date 2020/8/17
 * @since
 */
class Complex(var real: Double, var imaginary: Double) {

    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    operator fun plus(other: Int): Complex {
        return Complex(real + other, imaginary)
    }

    operator fun plus(other: Any): Int {
        return real.toInt()
    }

    operator fun invoke(): Double {
        // 开平方
        return Math.hypot(real, imaginary)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

class Book{
    // infix 中缀表达式 只有一个参数
    infix fun on(any: Any): Boolean{
        return false
    }
}

class Desk

fun main(args: Array<String>) {
    val c1 = Complex(3.0, 4.0)
    val c2 = Complex(1.0, 2.0)
    println(c1 + c2) //4.0 + 6.0i
    println(c1 + 5) // 8.0 + 4.0i
    println(c1 + "hello") // 3
    println(c1) // 3+4i
    println(c1.invoke()) // 5.0

    //-name <Name> 常用的 in
    if("-name" in args){
        println(args[args.indexOf("-name") + 1])
    }

    // on 是方法
    if(Book() on Desk()){ // dsl

    }

}