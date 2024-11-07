package com.advance.kotlin.hello_algo.code_15_tanxin

import kotlin.math.pow

/**
 * 给定一个正整数
 *  ，将其切分为至少两个正整数的和，求切分后所有整数的乘积最大是多少
 * @author xugang
 * @date 2024/10/22
 */

/*
* 确定贪心策略
* 1.找出最优子结构
* 2（n-2）>= n
*  2n>= n+4
*   n>=4
* 大于4的整数都该被继续切分
*
*  排除 1
*  当n=6时 排除 2
*
*  在切分方案中，最多只应存在两个2 。因为三个2总是可以替换为两个3，从而获得更大的乘积
*
*  综上所述，可推理出以下贪心策略。
*  不断切分出因子3，直至余数为0、1、2
*  当余数为0，n是3的倍数，不做处理
*  当余数为2，不能继续划分，保留
*  当余数为1，由于2x2>1x3 因此将最后一个3替换为2
*
*/
fun maxProductCutting(n: Int): Int {
    // 当 n <=3 时，必须切分出一个 1
    if (n <= 3) {
        return 1 * (n - 1)
    }

    // 贪心的切换出3
    val a = n / 3
    val b = n % 3

    if (b == 1) {
        return 3.0.pow((a - 1)).toInt() * 2 * 2
    }

    if (b == 2) {
        return 3.0.pow(a).toInt() * 2
    }

    return 3.0.pow(a).toInt()
}

fun main() {
    println(maxProductCutting(11))
}