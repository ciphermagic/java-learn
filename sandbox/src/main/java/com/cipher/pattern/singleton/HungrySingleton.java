package com.cipher.pattern.singleton;

/**
 * 饿汉单例模式
 * Created by cipher on 2017/9/5.
 */
public class HungrySingleton {

    // 私有化默认的构造方法，防止外界直接创建实例
    private HungrySingleton() {
    }

    // 创建类的唯一实例，类加载时创建实例
    private static HungrySingleton instance = new HungrySingleton();

    // 提供外界获取实例
    public static HungrySingleton getInstance() {
        return instance;
    }

}
