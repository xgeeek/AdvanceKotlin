package xxjg.learn.kotlin.mkotlin.cstruct

/**
 * 表达式 分支
 * @author xugang on 2019/11/6
 */
private const val USER_NAME = "kotlin"
private const val PASSWORD = "kotlin"

private const val ADMIN_USER = "admin"
private const val ADMIN_PASSWORD = "admin"

private const val DEBUG = 1
private const val USER = 0

private fun logig(mode: Int) {
    // 条件表达式 有返回值
    val mode = if (mode == 1) {
        DEBUG
    } else {
        USER
    }

    println("请输入用户名：")
    val username = readLine()
    println("请输入密码：")
    val passwd = readLine()

    if (mode == DEBUG && username == ADMIN_USER && passwd == ADMIN_PASSWORD) {
        println("管理员登录成功")
    } else if (username == USER_NAME && passwd == PASSWORD) {
        println("登录成功")
    } else {
        println("登录失败")
    }
}

// 注意 when  的每个条件用空行隔开 （代码风格）
private fun whenTest(condi: Int) {
    val x = 5
    when (x) {
        // 注意只会执行一种情况 就不会执行其他情况
        is Int -> println("Hello $x")

        in 1..100 -> println("$x is in 1..100")

        condi -> println("condi == x")
    }

    val mode = when {
        condi == 5 -> "1"
        else -> "0"
    }

}

fun main(args: Array<String>) {
    whenTest(5)
    logig(0)
    logig(1)
}