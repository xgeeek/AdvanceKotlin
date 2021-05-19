package com.advance.kotlin.grammar.cOrientedObject

import android.widget.TextView

/**
 * 扩展成员 而不用影响原有功能
 * 类名.xxx
 * 子类是不可以重写父类的扩展函数
 * @author xugang
 * @date 2020/8/30
 * @since
 */
class Expand {

    val str = "expand"

    /**
     * 增加了一个属性  扩展属性实际上就是提供某个属性访问的set,get方法，这两个set，get方法是静态函数，
     *  同时都会传入一个接收者类型的对象，然后在其内部用这个对象实例去访问和修改对象所对应的类的属性。
     */
    var TextView.isBolder: Boolean
        get() {
            return this.paint.isFakeBoldText
        }
        set(value) {
            this.paint.isFakeBoldText = true
        }


    fun fieldInvoke() {
        val textView: TextView? = null
        textView?.isBolder
    }

    /**
     * 首先是成员函数
     * 然后是扩展函数
     * 类里的扩展函数，必须使用前缀类对象来使用我
     */
    fun String.times2(int: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until int) {
            stringBuilder.append(this)
        }
        return stringBuilder.toString()
    }

    fun main() {
        "".times2(2)
    }
}

/**
 * ★★★：作用域的理解
 * 扩展函数写在哪里都可以，写的位置不同，作用域就也不同。
 * 所谓的作用域就是说你能在哪些地方调用到它。
 * 最简单的写法就是把它写成Top Level也就是最顶层的，让它不属于任何类，这样你就能在任何类里使用它。
 * 这和成员函数的作用域很像---哪里能用到这个类，哪里就能用到类里的这个函数。
 *
 * 看下面这个扩展函数，它是不属于任何类的，不像成员函数。
 * 只是再函数声明的左边限定一个Receiver接收器，这个函数只有通过我限制的这个类的对象才能调用。
 */
operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

fun main(args: Array<String>) {
    println("abc" * 16)

    val str = "scope"
    str.times(2)

    val time: String.(Int) -> String = String::times  // 有Receiver的
    val time2: (String, Int) -> String = String::times // 无Receiver的

    time.invoke("", 2) // 第一个参数为调用者
    time2.invoke("", 2)


}