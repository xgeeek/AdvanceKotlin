package com.advance.kotlin.grammar.zList

/**
 * @author xugang
 * @date 2021/11/3
 */
fun filterTest() {
    val numbers = listOf("one", "two", "three", "four")
    // predicate: (T) -> Boolean
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
    println(filteredMap)

    val filteredIdx = numbers.filterIndexed { index, s -> (index != 0) && (s.length < 5) }
    // 否定条件过滤
    val filteredNot = numbers.filterNot { it.length <= 3 }

    println(filteredIdx)
    println(filteredNot)

    val (match, rest) = numbers.partition { it.length > 3 }
    println(match) // 匹配的
    println(rest)   // 未匹配的
}


fun main(args: Array<String>) {
    filterTest()
}