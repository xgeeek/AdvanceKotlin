package com.advance.kotlin.grammar.cOrientedObject;

/**
 * java 调用 kotlin
 *
 * @author xugang on 2019/11/7
 */
public class JavaUseKt {
    public static void main(String[] args) {

        // 使用单例
        MusicPlayer player = MusicPlayer.INSTANCE;
        player.play("http://www.baidu.com/aini.mp3");

        // 使用伴生对象
        Latiude latitude = Latiude.Companion.ofDouble(3.7);
        Latiude.ofLatitude(latitude);
        System.out.println(Latiude.TAG);

        // 参数默认值
        OverLoads overLoads = new OverLoads();
        overLoads.a();

        // 调用扩展函数  注意首字母变成大写的了
        GKuoZhanKt.times("abc", 7);
    }
}
