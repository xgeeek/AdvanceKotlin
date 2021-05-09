package com.advance.kotlin.grammar.cOrientedObject

/**
 * 枚举
 * @author xugang
 * @date 2021/5/9
 * @since
 */

enum class LogLevel(val name2:String) {
    VERBOSE("普通"),
    WARN("警告"),
    // kotlin 唯一需要写分号的地方
    ERROR("错误");

    fun getName():String{
        return "$name2"
    }
}

fun main() {
    print(LogLevel.VERBOSE)
    // 返回枚举所有实例
    print(LogLevel.values())
}