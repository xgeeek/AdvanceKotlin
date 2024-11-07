package com.advance.kotlin.hello_algo

import java.util.LinkedList

/**
 * @author xugang
 * @date 2024/10/17
 */

/* 递归 */
fun recur(n: Int): Int {
    if (n == 1) {
        return 1
    }
    val res = recur(n - 1)
    return n + res
}


/* 斐波那契数列：递归 */
fun fib(n: Int): Int {
    // 0 1 1 2 3 5 8 13   递归树
    if (n <= 1) {
        return n
    }
    return fib(n - 1) + fib(n - 2)
}


/* 时间复杂度0(2^n) */
fun exponential(n: Int): Int {
    // 细胞分裂
    var count = 0
    var base = 1
    // 细胞每轮一分为二，形成数列 1, 2, 4, 8, ..., 2^(n-1)
    for (i in 0..n) {
        for (j in 0..base) {
            count++
        }
        base *= 2
    }
    // count = 1 + 2 + 4 + 8 + .. + 2^(n-1) = 2^n - 1
    return count
}

/* 层序遍历 */
fun levelOrder(root: TreeNode?): MutableList<Int> {
    // 初始化队列，加入根节点
    val queue = LinkedList<TreeNode?>()
    queue.add(root)

    val list = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        list.add(node?.nodeValue!!)
        if (node.left != null) queue.offer(node.left)   // 左子节点入队
        if (node.right != null) queue.offer(node.right)  // 右子节点入队
    }

    return list
}

/* 前序遍历 */
val preList = mutableListOf<Int>()
fun preOrder(root: TreeNode?) {
    // 访问优先级：根节点 -> 左子树 -> 右子树
    if (root == null) {
        return
    }
    preList.add(root.nodeValue)
    preOrder(root.left)
    preOrder(root.right)
}


/* 中序遍历 */
val inList = mutableListOf<Int>()
fun inOrder(root: TreeNode?) {
    // 访问优先级：左子树 -> 根节点 -> 右子树
    if (root == null) {
        return
    }
    inOrder(root.left)
    inList.add(root.nodeValue)
    inOrder(root.right)
}


/* 后序遍历 */
val postList = mutableListOf<Int>()
fun postOrder(root: TreeNode?) {
    // 访问优先级：左子树 -> 右子树 -> 根节点
    if (root == null) {
        return
    }
    postOrder(root.left)
    postOrder(root.right)
    postList.add(root.nodeValue)
}


fun main() {
    //递归
    println(recur(5))
    println(fib(5))
    println(exponential(5))

    //二叉树
    val n1 = TreeNode(1)
    val n2 = TreeNode(2)
    val n3 = TreeNode(3)
    val n4 = TreeNode(4)
    val n5 = TreeNode(5)
    val n6 = TreeNode(6)
    val n7 = TreeNode(7)

    n1.left = n2
    n1.right = n3

    n2.left = n4
    n2.right = n5

    n3.left = n6
    n3.right = n7

    println(levelOrder(n1).toString())

    preList.clear()
    preOrder(n1)
    println(preList.toString())

    inList.clear()
    inOrder(n1)
    println(inList.toString())

    postList.clear()
    postOrder(n1)
    println(postList.toString())


}