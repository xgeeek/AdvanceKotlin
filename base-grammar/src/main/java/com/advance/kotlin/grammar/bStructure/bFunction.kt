package com.advance.kotlin.grammar.bStructure

/**
 * 函数 lambda
 * @author xugang
 * @date 2020/8/10
 * @since
 */
// 返回值
fun sum(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}

// 函数体 简单的一个表达式 返回值类型自动推断
fun simpleSum(arg1: Int, arg2: Int) = arg1 + arg2

// 匿名函数 要有赋值
val int2Long = fun(arg: Int): Long {
    return arg.toLong()
}

// lambda 匿名函数 （Int,Int）-> Int
val sumLambda = {arg1: Int, arg2: Int ->
    // 默认最后一行是返回值
    arg1 + arg2
}

// ()-> Unit
val printHello = {
    println("Hello world")
}


// Unit 相当于 java 的 void
fun main(args: Array<String>): Unit {
    println(int2Long(234))
    // 最多到 Function22
    println(int2Long) // Function1<java.lang.Integer, java.lang.Long>

    // lambda
    println(sumLambda(1,2))

//    for (i in args){
//        println(i)
//    }

    // （T）-> Unit
//    args.forEach {
//        println(it)
//    }

    // 完整写法  forEach()里是个 action
//    args.forEach ({element->
//        println(element)
//    })

    // 括号可以省略
//    args.forEach() {
//        println(it)
//    }

    // 参数一致
//    args.forEach(::println)

    // lambda 表达式在这里是个参数
    // 这个 return 是直接 return 的 main 函数
    // 下面语句不会在执行  所以加个 ForEach 标签 表示当前返回
    args.forEach ForEach@{
        if(it == "q")
            return@ForEach  // return 当前循环 相当于 Continue
        println(it)
    }
    println("the end")

    println(printHello is ()->Unit)

}




