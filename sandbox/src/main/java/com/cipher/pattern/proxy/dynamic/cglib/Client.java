package com.cipher.pattern.proxy.dynamic.cglib;

import com.cipher.pattern.proxy.Car;

/**
 * CGLIB 动态代理测试类
 * Created by cipher on 2017/9/6.
 */
public class Client {

    public static void main(String[] args) {
        // 记录时间
        CarTimeProxy carTimeProxy = new CarTimeProxy();
        Car carByTime = (Car) carTimeProxy.getProxy(Car.class);
        carByTime.move();
        System.out.println("-----------");
        // 记录日志
        CarLogProxy carLogProxy = new CarLogProxy();
        Car carByLogTime = (Car) carLogProxy.getProxy(Car.class);
        carByLogTime.move();
    }

}
