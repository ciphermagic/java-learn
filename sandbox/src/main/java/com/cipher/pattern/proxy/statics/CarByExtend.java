package com.cipher.pattern.proxy.statics;

import com.cipher.pattern.proxy.Car;

/**
 * 继承方式实现代理（不推荐）
 * Created by cipher on 2017/9/6.
 */
public class CarByExtend extends Car {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("汽车开始行驶......");
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("汽车结束行驶......行驶时间：" + (end - start) + "毫秒");
    }

}
