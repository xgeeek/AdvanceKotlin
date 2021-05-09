package com.advance.kotlin.grammar.cOrientedObject

/**
 * 密封类
 *
 * 子类有限的类
 *
 * 注意跟枚举的区别
 *
 * 子类可以定义在内部  或 同一个文件中
 * @author xugang
 * @date 2021/5/9
 * @since
 */
sealed class PlayerCmd {
    class Play : PlayerCmd()
    class Seek : PlayerCmd()
    object Pause : PlayerCmd()
    object Stop : PlayerCmd()
}

enum class PlayerState {
    PLAYING, PAUSE
}

class KSealedClass {
}