package com.advance.kotlin.grammar.cOrientedObject

/**
 * 方法签名相同
 * 返回值类型要相同
 * @author xugang
 * @date 2020/8/29
 * @since
 */
abstract class A {
    open fun x(): Int = 5
}

interface B {
    fun x(): Int = 1
}

interface C {
    fun x(): Int = 0
}

class D(var y: Int = 0) : A(), B, C {
    override fun x(): Int {
        println("call x() in D")
        if (y > 0) {
            return y
        } else if (y < -200) {
            // 泛型
            return super<C>.x()
        } else if (y < -100) {
            return super<B>.x()
        } else {
            return super<A>.x()
        }
    }
}

fun main(args: Array<String>) {

}
