package com.advance.kotlin.grammar.zList

/**
 * @author xugang
 * @date 2021/11/3
 */

/**
 * Iterable<T> 接口的继承者（包括 Set 与 List）可以通过调用 iterator() 函数获得迭代器。
 * 一旦获得迭代器它就指向集合的第一个元素；调用 next() 函数将返回此元素，并将迭代器指向下一个元素（如果下一个元素存在）。
 * 一旦迭代器通过了最后一个元素，它就不能再用于检索元素；也无法重新指向到以前的任何位置。要再次遍历集合，请创建一个新的迭代器
 */
class DieDai {

    fun iterableWhile() {
        val numList = mutableListOf(1, 2, 3, 4, 5)
        val iterator = numList.iterator()
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }

    /**
     * 为了迭代可变集合，于是有了 MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove()
     * 因此，可以在迭代时从集合中删除插入元素。
     */
    fun changeIterable() {
        val numbers = mutableListOf("one", "two", "three", "four")
        val mutableIterator = numbers.iterator()

        mutableIterator.next()
        mutableIterator.remove()
        println("After removal: $numbers")

        val numbers2 = mutableListOf("one", "four", "four")
        val mutableListIterator = numbers2.listIterator()

        mutableListIterator.next()
        mutableListIterator.add("two")
        mutableListIterator.next()
        mutableListIterator.set("three")
        println(numbers2)
    }
}


class QuJian {

    fun rangeTest() {
        for (i in 1..4) {
            println(i)
        }

        // 反向迭代
        for (i in 4 downTo 2) {
            println(i)
        }

        // 指定步长
        for (i in 8 downTo 1 step 2) println(i)

        // 不包含最后一位
        for (i in 1 until 5) {
            println(i)
        }
    }

}

fun main(args: Array<String>) {
    val diedai = DieDai()
    diedai.iterableWhile()
    diedai.changeIterable()

    val quJian = QuJian()
    quJian.rangeTest()
}