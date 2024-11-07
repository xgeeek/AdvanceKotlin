package com.advance.kotlin.hello_algo.code_8_heap

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue
import java.util.Queue
import kotlin.math.abs
import kotlin.random.Random

/**
 *
 * 堆（heap）是一种满足特定条件的完全二叉树，主要可分为两种类型
 *
 * 小顶堆（min heap）：任意节点的值<=其子节点的值
 *
 * 大顶堆（max heap）：任意节点的值>=其子节点的值
 *
 * 堆通常用于实现优先队列，大顶堆相当于元素按从大到小的顺序出队的优先队列
 *
 * @author xugang
 * @date 2024/10/22
 */

@RequiresApi(Build.VERSION_CODES.N)
class Heap() {

    var minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue { a: Int, b: Int -> b - a }

    fun test() {
        // 元素入堆
        maxHeap.offer(1)
        maxHeap.offer(3)
        maxHeap.offer(2)
        maxHeap.offer(5)
        maxHeap.offer(4)

        // 获取堆顶元素
        var peek = maxHeap.peek()

        // 出堆
        println(maxHeap.poll())
        println(maxHeap.poll())
        println(maxHeap.poll())
        println(maxHeap.poll())
        println(maxHeap.poll())


        minHeap = PriorityQueue(mutableListOf(1, 3, 2, 5, 4))
        println(minHeap.poll())
        println(minHeap.poll())
        println(minHeap.poll())
        println(minHeap.poll())
        println(minHeap.poll())
    }


}


/* 获取左子节点的索引 */
fun left(i: Int): Int {
    return 2 * i + 1
}

/* 获取右子节点的索引 */
fun right(i: Int): Int {
    return 2 * i + 2
}

/* 获取父节点的索引 */
fun parent(i: Int): Int {
    return (i - 1) / 2 // 向下整除
}

/* 基于堆查找数组中最大的 k 个元素 */
fun topKHeap(nums: IntArray, k: Int): Queue<Int> {
    // 初始化小顶堆
    val heap = PriorityQueue<Int>()
    // 将数组的前 k 个元素入堆
    for (i in 0 until k) {
        heap.offer(nums[i])
    }
    // 从第 k+1 个元素开始，保持堆的长度为 k
    for (i in k until nums.size) {
        // 若当前元素大于堆顶元素，则将堆顶元素出堆、当前元素入堆
        if (nums[i] > heap.peek()) {
            heap.poll()
            heap.offer(nums[i])
        }
    }
    return heap
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val heap = Heap()
    heap.test()

    val list = mutableListOf<Int>()
    for (i in 1..10000) {
        list.add(Random.nextInt(10000))
    }

    val start = System.currentTimeMillis()
    val topKHeap = topKHeap(list.toIntArray(), 100)
    val end = System.currentTimeMillis()
    println(end - start)
    while (topKHeap.isNotEmpty()) {
        print(topKHeap.poll())
        print(",")
    }


    val start2 = System.currentTimeMillis()
    list.sortByDescending {
        it
    }
    val end2 = System.currentTimeMillis()
    println(end2 - start2)
    println(list.subList(0, 100))

}