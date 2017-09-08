package com.cipher.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

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

    public void update(Observable o, Object arg) {
        this.weacher = ((WeatherStationSubject) o).getWeather();
        System.out.println(String.format("【JDK】%s收到通知：%s", this.name, this.weacher));
    }
}
