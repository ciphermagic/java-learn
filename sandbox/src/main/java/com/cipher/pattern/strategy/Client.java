package com.cipher.pattern.strategy;

/**
 * 策略模式测试类
 * Created by cipher on 2017/9/12.
 */
public class Client {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.quack();
        mallardDuck.fly();
        System.out.println("------------------------------");
        Duck redheadDuck = new RedheadDuck();
        redheadDuck.display();
        redheadDuck.quack();
        redheadDuck.fly();
        System.out.println("------------------------------");
        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.quack();
        rubberDuck.fly();
        System.out.println("------------------------------");
        Duck spaceDuck = new SpaceDuck();
        spaceDuck.display();
        spaceDuck.quack();
        spaceDuck.fly();
    }

}
