package com.advance.kotlin.grammar.zList

/**
 * 常见的集合操作
 * @author xugang
 * @date 2021/11/3
 */
class ZhuanHuan {

    /**
     * 映射
     *
     * map() 从一个集合的元素创建一个集合
     * mapIndexed() 操作时需要索引
     */
    fun mapTest() {
        val num = setOf(1, 2, 3)
        println(num.map {
            it * 3
        })
        println(num.mapIndexed { index, i -> i * index })

        // 映射非null元素
        println(num.mapNotNull { if (it == 2) null else it * 3 })
        println(num.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })

        // map映射可以单独对key或者value
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        println(numbersMap.mapKeys { it.key.toUpperCase() })
        println(numbersMap.mapValues { it.value + it.key.length })
    }


    /**
     * 合拢
     * 根据两个集合相同位置的元素构建配对  返回Pair对象的list
     * 以较小集合为准
     */
    fun zipTest() {
        val colors = listOf("red", "brown", "grey")
        val animals = listOf("fox", "bear", "wolf")
        val list = colors zip animals
        println(list)

        val twoAnimals = listOf("fox", "bear")
        println(colors.zip(twoAnimals))
    }


    /**
     * 关联
     * 允许从集合元素和与其关联的某些值构建 Map
     */
    fun associateWithTest() {
        val numbers = listOf("one", "two", "three", "four")
        // numbers 是 key
        println(numbers.associateWith { it.length })
    }

}

fun main(args: Array<String>) {
    val zhuanHuan = ZhuanHuan()
    //zhuanHuan.mapTest()
    zhuanHuan.zipTest()
    zhuanHuan.associateWithTest()
}