package com.cipher.pattern.observer.special;

import java.util.Arrays;

/**
 * 具体的观察者对象，实现更新的方法，使自己的状态和目标的状态保持一致
 * Created by cipher on 2017/9/8.
 */
public class ConcreteObserver implements Observer {

    private String name;

    private String weather;

    private String[] interestWeacher;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(Subject subject) {
        System.out.println(String.format("%s收到通知：%s", this.name, this.weather));
    }

    public boolean isInterest(Subject subject) {
        this.weather = ((WeatherStationSubject) subject).getWeather();
        if (Arrays.asList(interestWeacher).contains(this.weather)) {
            return true;
        }
        return false;
    }

    public void setInterestWeacher(String[] interestWeacher) {
        this.interestWeacher = interestWeacher;
    }


}
