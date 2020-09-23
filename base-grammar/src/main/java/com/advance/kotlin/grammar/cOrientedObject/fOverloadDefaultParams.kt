package com.advance.kotlin.grammar.cOrientedObject

/**
 * 尽量避免重载
 * 方法签名 不包括返回值
 * 重载 默认参数
 *
 * eg: list.remove(int)
 *     list.remove(index)
 * @author xugang on 2019/11/7
 */
class OverLoads {

    // 默认参数   这样上面的就可以省略
    /**
     * java 里使用默认参数 加 JvmOverloads 注解
     */
    @JvmOverloads
    fun a(int: Int = 1): Int {
        return int
    }

}

fun main(args: Array<String>) {
    val overLoads = OverLoads();
    // 默认参数
    overLoads.a();
    overLoads.a(5)
}