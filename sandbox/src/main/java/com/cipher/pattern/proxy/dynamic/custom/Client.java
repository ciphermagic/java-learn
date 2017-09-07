package com.cipher.pattern.proxy.dynamic.custom;

import com.cipher.pattern.proxy.Car;
import com.cipher.pattern.proxy.Moveable;

/**
 * 自定义模拟 JDK 动态代理测试类
 * Created by cipher on 2017/9/6.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new TimeHandler(new Car());
        Moveable moveable = (Moveable) Proxy.newProxyInstance(Moveable.class, handler);
        moveable.move();
    }

}
