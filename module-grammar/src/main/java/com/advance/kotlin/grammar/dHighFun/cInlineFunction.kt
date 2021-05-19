package com.advance.kotlin.grammar.dHighFun

/**
 * @author xugang
 * @date 2021/5/14
 */

/**
 * 1. inline 内联函数
 */
inline fun payFoo(block: () -> Unit) {
    println("before block")
    block()
    println("end block")
}

/*public final class BAdvanceFunctionKt {
   public static final void payFoo(@NotNull Function0 block) {  // 会产生一个Function0的类
      Intrinsics.checkNotNullParameter(block, "block");
      String var1 = "before block";
      boolean var2 = false;
      System.out.println(var1);
      block.invoke();
      var1 = "end block";
      var2 = false;
      System.out.println(var1);
   }

   public static final void main() {
      payFoo((Function0)null.INSTANCE);
   }

   // $FF: synthetic method
   public static void main(String[] var0) {
      main();
   }
}*/

// 加上inline后， 如果是循环中会被调用多次。 消除额外调用，从而节约开销
/*
public final class BAdvanceFunctionKt {
   public static final void payFoo(@NotNull Function0 block) {
      int $i$f$payFoo = 0;
      Intrinsics.checkNotNullParameter(block, "block");
      String var2 = "before block";
      boolean var3 = false;
      System.out.println(var2);
      block.invoke();
      var2 = "end block";
      var3 = false;
      System.out.println(var2);
   }

   public static final void main() { // 函数体代码被调用的代码都粘贴到了相应调用的位置
      int $i$f$payFoo = false;
      String var1 = "before block";
      boolean var2 = false;
      System.out.println(var1);
      boolean var3 = false;
      var1 = "end block";
      var2 = false;
      System.out.println(var1);
   }

   // $FF: synthetic method
   public static void main(String[] var0) {
      main();
   }
}

 */


/**
 * 2. 避免使用内联的情况
 *   1.由于JVM对普通函数已经能够根据实际情况智能地判断是否进行内联优化，所以我们并不需要对其使用Kotlin的inline语法，那只会让字节码变得更加复杂。
 *   2.尽量避免对具有大量函数体的函数进行内联，这样会导致过多的字节码数量。
 *   3.一旦一个函数被定义为内联函数，便不能获取闭包类的私有成员，除非你把它们声明为internal。
 */
class TestPay {
    private var a = -1

    internal inline fun printNum() {
        println(a)
    }
}


/**
 * 3. 避免内联 noinline
 */
inline fun payFoo(block1: () -> Unit, noinline block2: () -> Unit) {
    println("before block")
    block1()
    block2()
    println("end block")
}


fun main() {
    payFoo {
    }
}


