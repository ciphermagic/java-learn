package com.cipher.pattern.singleton;

/**
 * 懒汉单例模式
 * Created by cipher on 2017/9/5.
 */
public class LazySingleton {

    // 私有化默认的构造方法，防止外界直接创建实例
    private LazySingleton() {
    }

    // 声明类的唯一实例，初始化为null
    private static LazySingleton instance = null;

    // 提供外界获取实例
    public static LazySingleton getInstance() {
        // 被调用时创建实例
        if (instance == null) {
            System.out.println("创建懒汉单例模式实例");
            instance = new LazySingleton();
        }
        return instance;
    }

}
