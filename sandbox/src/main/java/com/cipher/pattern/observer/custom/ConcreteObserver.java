package com.cipher.pattern.observer.custom;

/**
 * 具体的观察者对象，实现更新的方法，使自己的状态和目标的状态保持一致
 * Created by cipher on 2017/9/8.
 */
public class ConcreteObserver implements Observer {

    private String name;

    private String weacher;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(Subject subject) {
        this.weacher = ((WeatherStationSubject) subject).getWeather();
        System.out.println(String.format("【拉模型】%s收到通知：%s", this.name, this.weacher));
    }

    public void updateByPush(String content) {
        this.weacher = content;
        System.out.println(String.format("【推模型】%s收到通知：%s", this.name, this.weacher));
    }

}
