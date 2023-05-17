package com.advance.kotlin.grammar.zList

import android.util.Log
import java.util.*

/**
 * list 有序集合，可重复
 * set 无序，不可重复
 * Map key不可重复，value可重复
 *
 * 一对接口代表集合类型
 *  只读接口： 访问
 *  可变接口： 访问，添加和删除以及更新
 * @author xugang
 * @date 2021/11/3
 */

/**
 * 通过元素构造
 *  listOf<T>()、setOf<T>()、mutableListOf<T>()、mutableSetOf<T>()
 *  mapOf()、mutableMapOf() ： map 使用中缀符 to
 *
 *  通过空集合构造
 *  emptyList()、emptySet()、emptyMap()
 */
fun elementAndEmptyCreate() {
    val numLis = listOf(1, 2, 3)
    val numLis2 = mutableListOf(1, 2, 3)

    val numMap = mapOf("1" to 1, "2" to 2, "3" to 3)
    val numMap2 = mutableMapOf<String, Int>().apply {
        this["1"] = 1
        this["2"] = 2
    }

    val empty = emptyList<String>() // 需要指定类型
}


/**
 * 通过list初始化函数构造
 * 通过具体类型的构造函数构造
 *
 * 通过已有集合的复制方法来构造
 * toList()、toMutableList()、toSet()  相互独立
 */
fun initAndCopyCreate() {
    val listCreate = List(3) { it * 2 } // it---index
    print(listCreate)

    val linkedList = LinkedList<String>()
    linkedList.add("")
    val presizedSet = HashSet<Int>(32)

    // 复制
    val sourceList = mutableListOf(1, 2, 3)
    val copyList = sourceList.toMutableList()
    val readOnlyCopyList = sourceList.toList()
    sourceList.add(4)
    println("Copy size: ${copyList.size}")
    //readOnlyCopyList.add(4)             // 编译异常
    println("Read-only copy size: ${readOnlyCopyList.size}")

    //list 转 set
    val copySet = sourceList.toMutableSet()
}

/**
 * 通过集合的函数生成函数
 */
fun byOtherListCreate() {
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
}


fun main(args: Array<String>) {
    initAndCopyCreate()

    Thread(){
        while (true){
            println("111")
        }
        println("222")
        println("333")
    }.start()

}

