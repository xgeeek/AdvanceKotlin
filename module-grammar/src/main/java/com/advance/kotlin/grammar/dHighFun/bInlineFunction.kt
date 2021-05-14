package com.advance.kotlin.grammar.dHighFun

/**
 * @author xugang
 * @date 2021/5/14
 */

/**
 * inline 内联函数
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

fun main() {
    payFoo {

    }
}


