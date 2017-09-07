package com.cipher.pattern.proxy;

import java.util.Random;

/**
 * 汽车类，实现行驶接口
 * Created by cipher on 2017/9/6.
 */
public class Car implements Moveable {

    public void move() {
        // 实现行驶
        try {
            System.out.println("汽车行驶中......");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
