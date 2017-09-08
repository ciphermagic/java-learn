package com.cipher.pattern.observer.special;


/**
 * 观察者模式测试类
 * Created by cipher on 2017/9/8.
 */
public class Client {

    public static void main(String[] args) {
        // 创建目标
        WeatherStationSubject ws = new WeatherStationSubject();
        // 创建观察者
        ConcreteObserver girlfriend = new ConcreteObserver("女朋友");
        girlfriend.setInterestWeacher(new String[]{"晴朗", "下雨"});
        ConcreteObserver mom = new ConcreteObserver("老妈");
        mom.setInterestWeacher(new String[]{"晴朗"});
        // 注册观察者
        ws.attach(girlfriend, mom);
        // 目标发布天气
        ws.setWeather("下雨");
    }

}
