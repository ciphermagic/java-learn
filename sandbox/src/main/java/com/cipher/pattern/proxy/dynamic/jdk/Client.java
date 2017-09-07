package com.cipher.pattern.proxy.dynamic.jdk;

import com.cipher.pattern.proxy.Car;
import com.cipher.pattern.proxy.Moveable;

import java.lang.reflect.Proxy;

/**
 * JDK 动态代理测试类
 * Created by cipher on 2017/9/6.
 */
public class Client {

    public static void main(String[] args) {
        // 记录时间
        Moveable carByTime = getTimeProxy(new Car());
        carByTime.move();
        System.out.println("-------------------------");
        // 记录日志、记录时间
        Moveable carByLogTime = getLogProxy(getTimeProxy(new Car()));
        carByLogTime.move();
    }

    // 获取时间记录的代理
    private static Moveable getTimeProxy(Moveable m) {
        TimeHandler timeHandler = new TimeHandler(m);
        // 传入代理类的类加载器，代理类实现的接口，代理处理器
        return (Moveable) Proxy.newProxyInstance(Car.class.getClassLoader(), Car.class.getInterfaces(), timeHandler);
    }

    // 获取日志的代理
    private static Moveable getLogProxy(Moveable m) {
        LogHandler logHandler = new LogHandler(m);
        return (Moveable) Proxy.newProxyInstance(Car.class.getClassLoader(), Car.class.getInterfaces(), logHandler);
    }

}
