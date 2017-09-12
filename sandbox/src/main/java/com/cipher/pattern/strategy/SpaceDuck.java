package com.cipher.pattern.strategy;

import com.cipher.pattern.strategy.impl.FlyWithRocket;

/**
 * 太空鸭：具体的鸭子
 * Created by cipher on 2017/9/12.
 */
public class SpaceDuck extends Duck {

    public SpaceDuck() {
        super.setFlyingStrategy(new FlyWithRocket());
    }

    public void display() {
        System.out.println("我是太空鸭");
    }

    // 覆盖父类方法
    public void quack() {
        System.out.println("我用无线电与你通信~");
    }

}
