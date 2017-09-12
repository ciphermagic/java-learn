package com.cipher.pattern.strategy;

import com.cipher.pattern.strategy.impl.FlyNoWay;

/**
 * 橡皮鸭：具体的鸭子
 * Created by cipher on 2017/9/12.
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        super.setFlyingStrategy(new FlyNoWay());
    }

    public void display() {
        System.out.println("我是橡皮鸭");
    }

    // 覆盖父类方法
    public void quack() {
        System.out.println("嘎~嘎~嘎~");
    }

}
