package com.cipher.pattern.strategy;

import com.cipher.pattern.strategy.impl.FlyWithWing;

/**
 * 绿头鸭，具体的鸭子
 * Created by cipher on 2017/9/12.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        super.setFlyingStrategy(new FlyWithWing());
    }

    public void display() {
        System.out.println("我的脖子是绿色的");
    }

}
