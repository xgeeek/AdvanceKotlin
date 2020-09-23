package com.advance.kotlin.grammar.cOrientedObject

/**
 * 扩展成员
 * 类名.xxx
 * @author xugang
 * @date 2020/8/30
 * @since
 */

operator fun String.times(int: Int):String{
    val stringBuilder = StringBuilder()
    for(i in 0 until int){
        stringBuilder.append(this)
    }
    return stringBuilder.toString()

}

fun main(args: Array<String>) {
    if(args.isEmpty()){
    }

    println("abc" * 16)
}