package com.cipher.pattern.proxy.statics;

import com.cipher.pattern.proxy.Moveable;

/**
 * 聚合方式实现时间代理
 * Created by cipher on 2017/9/6.
 */
public class CarTimeProxy implements Moveable {

    private Moveable moveable;

    public CarTimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("汽车开始行驶......");
        moveable.move();
        long end = System.currentTimeMillis();
        System.out.println("汽车结束行驶......行驶时间：" + (end - start) + "毫秒");
    }

}
