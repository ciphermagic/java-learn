package com.cipher.pattern.observer.jdk;


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
        ConcreteObserver mom = new ConcreteObserver("老妈");
        // 注册观察者
        ws.addObserver(girlfriend);
        ws.addObserver(mom);
        // 目标发布天气
        ws.setWeather("天气晴朗");
    }

}
