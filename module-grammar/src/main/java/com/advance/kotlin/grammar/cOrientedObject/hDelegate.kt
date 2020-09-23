package com.advance.kotlin.grammar.cOrientedObject

import kotlin.reflect.KProperty

/**
 * 属性代理
 * 交给一个对象处理这个值
 * @author xugang on 2019/11/8
 */
class Delegates {
    // val 只需要 getValue
    val hello by lazy {
        "hello world"
    }

    val hello2 by MyDele()

    // var 需要 默认get()/set()方法
    // setValue() / getValue()
    var hello3 by MyDele()
}

class MyDele {
    private var value: String? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue: $thisRef -> ${property.name}")
        return value ?: ""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        println("setValue, $thisRef -> ${property.name} = $value")
        this.value = value
    }
}

fun main(args: Array<String>) {
    val delegates = Delegates()
    println(delegates.hello)
    println(delegates.hello2)
    println(delegates.hello3)
    delegates.hello3 = "value of hello3"
    println(delegates.hello3)
}