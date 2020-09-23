package com.advance.kotlin.grammar.cOrientedObject

/**
 * 类的继承
 * 类和方法默认都是 final 的  想要继承和实现必须加
 * open 关键字  或者定义成 abstract
 * @author xugang
 * @date 2020/8/29
 * @since
 */
// 构造器中的参数加上 val 变成全局变量 即当前类的属性了
abstract class Person(open val age: Int) {

    abstract fun work()

    // 默认不是 open 的 不能被重写
    fun workMine() {
        println("i am common method")
    }
}

// 抽象类的继承 属性的重写
class MaNong(age: Int) : Person(age) {

    // 想要重写属性 要父类开放权限
    override val age: Int
        get() = 0

    override fun work() {
        println("我是码农，我在写代码")
    }
}

class Doctor(age: Int) : Person(age) {

    override fun work() {
        println("我是医生，我在治病")
    }
}


// 接口的代理  多继承的曲线救国  6666
interface Driver {
    fun drive()
}

interface Writer {
    fun write()
}


class Manager : Driver, Writer {
    override fun drive() {
    }

    override fun write() {
    }

}


class CarDriver : Driver {
    override fun drive() {
        println("开车呢")
    }

}

class PPTWriter : Writer {
    override fun write() {
        println("写ppt呢")
    }

    open fun sing() {
        println("唱歌呢")
    }

}

// 自己本身会这两个功能 交由别人具体代写
// 接口代理 曲线救国  只是代理共同接口的方法
class SeniorManager(val driver: Driver, val writer: Writer) : Driver by driver, Writer by writer {
    fun work() {
        driver.drive()
        writer.write()
    }
}


fun main(args: Array<String>) {
    val person: Person = MaNong(23)
    person.work()
    println(person.age) // 0

    val person2: Person = Doctor(24)
    person2.work()
    println(person2.age) // 24

    val driver = CarDriver()
    val writer = PPTWriter()
    val seniorManager = SeniorManager(driver, writer)
    seniorManager.drive()
    seniorManager.write()
    seniorManager.work()

}