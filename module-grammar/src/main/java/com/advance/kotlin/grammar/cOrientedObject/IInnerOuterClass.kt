package com.advance.kotlin.grammar.cOrientedObject

/**
 * 默认的内部类是静态的(static)
 * @author xugang
 * @date 2021/5/8
 * @since
 */
open class Outter {
    val a: Int = 0

    class StaticInner {
        fun hello() {
            // 不持有
            //print("$a")
        }
    }

    inner class Inner {
        val a: Int = 5

        fun hello() {
            // 持有外部类的状态的
            print(a) //5
            print(this.a) //5
            print(this@Outter.a) //0
        }
    }

}

interface OnclickListener {
    fun onClick()
}


class View {
    var onClickListener: OnclickListener? = null
}

fun main() {
    val outter: Outter = Outter();
    outter.Inner().hello()

    // 匿名内部类 object: XXX{}
    // object 对象  ：继承（实现）的类
    // 匿名内部类可以继承 加实现多接口  这是java不能实现的
    var view = View()
    view.onClickListener = object : Outter(), OnclickListener {
        override fun onClick() {
            TODO("Not yet implemented")
        }
    }
}