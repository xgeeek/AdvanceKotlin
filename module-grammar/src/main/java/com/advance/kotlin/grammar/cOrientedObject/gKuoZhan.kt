package com.advance.kotlin.grammar.cOrientedObject

import android.widget.TextView

/**
 * 扩展成员 而不用影响原有功能
 * 类名.xxx
 *
 * @author xugang
 * @date 2020/8/30
 * @since
 */
class Expand {

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

}

// 子类是不可以重写父类的扩展函数
operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
    }

    println("abc" * 16)
}