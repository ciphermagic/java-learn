package com.cipher.pattern.proxy.statics;

import com.cipher.pattern.proxy.Car;
import com.cipher.pattern.proxy.Moveable;

/**
 * 静态代理测试类
 * Created by cipher on 2017/9/6.
 */
public class Client {

    public static void main(String[] args) {
        // 继承方式实现代理
        Moveable carByExtend = new CarByExtend();
        carByExtend.move();
        System.out.println("-----------------");
        // 聚合方式实现时间代理
        Moveable carTimeProxy = new CarTimeProxy(new Car());
        carTimeProxy.move();
        System.out.println("-----------------");
        // 聚合方式实现日志代理
        Moveable carLogProxy = new CarLogProxy(new Car());
        carLogProxy.move();
        System.out.println("-----------------");
        // 聚合方式实现时间、日志代理
        Moveable carTimeLogProxy = new CarTimeProxy(new CarLogProxy(new Car()));
        carTimeLogProxy.move();
    }

}
