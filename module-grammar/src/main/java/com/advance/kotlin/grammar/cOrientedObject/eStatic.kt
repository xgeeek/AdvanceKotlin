package com.advance.kotlin.grammar.cOrientedObject

/**
 * 伴生对象 静态成员变量
 * 像我们写工具类的时候 可以将构造器私有化
 * @author xugang
 * @date 2020/8/30
 * @since 1.0.0
 */
// 私有构造器的写法
class Latiude private constructor(val double: Double) {

    // 伴生对象
    companion object {
        /**
         *  省去 Companion 关键字
         *   JvmField 给java调用
         */
        @JvmField
        val TAG: String = "Latitude"

        // 静态方法
        fun ofDouble(double: Double): Latiude {
            return Latiude(double)
        }

        /**
         *  省去 Companion 关键字
         *  JvmStatic 给java调用
         */
        @JvmStatic
        fun ofLatitude(latitude: Latiude): Latiude {
            return Latiude(latitude.double)
        }
    }
}
