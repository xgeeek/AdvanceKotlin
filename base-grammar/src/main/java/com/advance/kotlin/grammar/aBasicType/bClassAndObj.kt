package com.advance.kotlin.grammar.aBasicType

/**
 * 类和对象
 * kotlin 中的所有父类 Any.kt
 * any 有三个方法 equals hashcode tostring
 *
 * @author xugang
 * @date 2020/8/9
 * @since
 */

// class 默认是 final 类型的
open class People(var name: String, var age: Int) {

    init {
        println("People 的初始化代码块 new ${this.javaClass.simpleName} ta 的姓名 $name ta 的年龄 $age")
    }
}


/**
 * 主构造函数 如果没有可见性修饰符或者注解 constructor可以省略
 *
 * 主构造函数不能有函数体(与类的代码块花括号无法区分) 初始化的操作可以放在 init初始化块中
 *
 * 可以有多个初始化块 按顺序执行
 * 初始化块是 主构造函数 的一部分
 *
 * 次构造函数是需要 委托给 主构造函数的
 *
 * 如果构造函数的所有参数都有默认值 编译器会默认生成一个额外的无参构造函数 使用默认值
 */
class MyGirl constructor(name: String, age: Int) : People(name, age) {

    init {
        println("MyGirl $name 的初始化块")
    }

    init {
        println("MyGirl $name 的初始化块 222 ")
    }

    constructor(name: String, age: Int, price: Double) : this(name, age) {
        println("次构造函数")
    }
}


fun main(args: Array<String>) {
    val myGirl: MyGirl = MyGirl("hxj", 25)
    val myGirl2: MyGirl = MyGirl("hxj2", 28, 10000.0)

    println(myGirl is People)

}
