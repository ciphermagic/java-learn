package com.cipher.pattern.strategy;

/**
 * 抽象类：所有鸭子都继承此类
 * 抽象了鸭子的行为：显示和鸣叫
 * Created by cipher on 2017/9/12.
 */
public abstract class Duck {

    // 飞行策略接口
    private FlyingStrategy flyingStrategy;

    // 子类注入飞行接口实现类
    public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
        this.flyingStrategy = flyingStrategy;
    }

    /**
     * 鸭子飞行，通过策略接口实现
     */
    public void fly() {
        this.flyingStrategy.performFly();
    }

    /**
     * 鸭子发出叫声
     * 通用行为，由超类实现
     */
    public void quack() {
        System.out.println("嘎嘎嘎~");
    }

    /**
     * 显示鸭子的外观
     * 鸭子的外观歌不相同，声明为 abstract,由子类实现
     */
    public abstract void display();

}
