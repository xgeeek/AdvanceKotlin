package com.advance.kotlin.grammar.cOrientedObject

/**
 * 类及其成员可见性
 * @author xugang
 * @date 2020/8/30
 * @since
 */
class House

class Flower

class ForbiddenCity {
    // 默认Public
    val houses = arrayOf(House(), House())
    val flowers = arrayOf(Flower(), Flower())
}

class CountYard {
    // 模块内可见
    internal val house: House = House()
    private val flower: Flower = Flower()
}

fun main(args: Array<String>) {
    var countYard: CountYard = CountYard()
    var forbiddenCity: ForbiddenCity = ForbiddenCity()

    println(forbiddenCity.houses)
}