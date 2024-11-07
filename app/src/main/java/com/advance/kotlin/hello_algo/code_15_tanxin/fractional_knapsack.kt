package com.advance.kotlin.hello_algo.code_15_tanxin

/**
 * 分数背包问题
 * @author xugang
 * @date 2024/10/22
 */


/* 物品 */
class Item(
    val w: Int,// 物品
    val v: Int // 物品价值
)


/**
 *  分数背包：贪心
 * @param wgt 物品重量
 * @param _val 物品价值
 * @param c 背包容量
 */
fun fractionalKnapsack(wgt: IntArray, _val: IntArray, c: Int): Double {
    var cap = c
    // 创建物品列表
    val items = arrayOfNulls<Item>(wgt.size)
    wgt.forEachIndexed { index, item ->
        items[index] = Item(wgt[index], _val[index])
    }
    // 按照单位价值从高到低排序
    items.sortByDescending {
        it!!.v.toDouble() / it.w
    }
    // 循环贪心选择
    var res = 0.0
    for (item in items) {
        if (item!!.w <= cap) {
            // 若剩余容量充足，则将当前物品整个装进背包
            res += item.v
            cap -= item.w
        } else {
            // 若剩余容量不足，则将当前物品的一部分装进背包
            res += item.v.toDouble() / item.w * cap
            // 已无剩余容量，因此跳出循环
            break
        }
    }
    return res
}


fun main() {
    val knapsack =
        fractionalKnapsack(intArrayOf(20, 40, 10, 30, 50), intArrayOf(120, 210, 50, 150, 240), 50)
    println(knapsack)
}