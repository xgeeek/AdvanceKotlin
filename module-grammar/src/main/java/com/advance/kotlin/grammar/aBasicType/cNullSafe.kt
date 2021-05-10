package com.advance.kotlin.grammar.aBasicType

/**
 * 空安全
 * @author xugang
 * @date 2020/8/9
 * @since
 */
class NullSafeClass {
    // 1. 修饰符 变量名 ： 类型? = 值
    var nullA: String? = ""

    fun invoke() {
        // 可空类型变量 ?.属性/方法
        println(nullA?.length)
        println(nullA?.length?.plus(5)?.minus(10))
    }

    // 2. 方法返回值为 null
    fun test1(): Int? {
        return null
    }


    // let 操作符 ?. 验证的时候忽略掉null
    fun testLet() {
        val arr: Array<Int?> = arrayOf(1, 2, null, 3, 4)
        for (values in arr) {
            values?.let {
                println(values)
            }
        }
    }

    // ?: 操作符 如果该变量不为空，则使用，反之使用另外一个不为空的值
    val testStr: String? = null
    var length = testStr?.length ?: -1

    // !! 操作符 可以理解为值不可能为空  所以当值为空的时候就会抛出 NullPointerException
}

// 返回 null 编译期不会通过的
//fun getName(): String {
//    return null
//}


//fun getName(): String {
//    return "hxj"
//}
//
//fun main(args: Array<String>) {
//    // 提示 always false 不可能返回 null
//    // kotlin 的空安全检查
//    if(getName() == null){
//
//    }
//}


// 我就想让 getName() 可以返回 null
// ? 标识当前被标识的可以为空 可空类型的对象
// 在使用的时候会提示可能为空的报错 使用安全的调用 println(getName()?.length)
//fun getName(): String? {
//    return null
//}


// 我就想让 getName() 可以返回 null
// ? 标识当前被标识的可以为空
// 在使用的时候会提示可能为空的报错
// 使用安全的调用 println(getName()?.length) 如果不为空返回 length 否则返回一个 null
//fun getName(): String? {
//    return null
//}

// 现在希望为空的时候  直接return 怎么办呢
//val name = getName()?:return
//println(name.length)


// 另外一种情况  我们已经知道不可能为 null
// 需要告诉编译器不可能为空 !! println(getName()!!.length)
fun getName(): String? {
    return null
}


fun main(args: Array<String>) {
    var testString: String? = null
    println(testString?.length) // null
    println(testString!!.length) //  java.lang.NullPointerException
}