package com.cipher.pattern.singleton;

/**
 * 单例模式测试
 * Created by cipher on 2017/9/5.
 */
public class Test {

    public static void main(String[] args) {
        // 饿汉
        HungrySingleton h1 = HungrySingleton.getInstance();
        HungrySingleton h2 = HungrySingleton.getInstance();
        System.out.println(h1 == h2);

        // 懒汉
        LazySingleton l1 = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();
        System.out.println(l1 == l2);
    }

}
