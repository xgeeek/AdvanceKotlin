package xxjg.learn.kotlin.mkotlin.cstruct

/**
 * 循环  for  while
 * continue  break
 * @author xugang on 2019/11/6
 */

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
    }

    for ((index, value) in args.withIndex()) {
        println("$index -> $value")
    }

    var list = MyList()
    list.add(1)
    list.add(2)
    list.add(3)

    for (int in list) {
        println("$int")
    }

    var x = 5
    while (x > 0) {
        println(x)
        x--
    }


    // try 也是表达式
    val result = try {
        args[0].toInt() / args[1].toInt()
    } catch (e: Exception) {
        println(e.message)
        0
    }
}

class MyIterator(val iterator: Iterator<Int>) {
    operator fun next(): Int {
        return iterator.next()
    }

    operator fun hasNext(): Boolean {
        return iterator.hasNext()
    }
}

class MyList {
    private val list = ArrayList<Int>()

    fun add(int: Int) {
        list.add(int)
    }

    fun remove(int: Int) {
        list.remove(int)
    }

    /**
     * 使用for循环的前提是  提供了迭代器对象
     *    有一个 iterator() 成员函数或者扩展函数 并且它的返回类型
     *        有一个 next() 成员函数或者扩展函数
     *        有一个 hasNext() 成员函数或者扩展函数
     *     这三个函数都要标记为 operator
     */
    operator fun iterator(): MyIterator {
        return MyIterator(list.iterator())
    }
}
