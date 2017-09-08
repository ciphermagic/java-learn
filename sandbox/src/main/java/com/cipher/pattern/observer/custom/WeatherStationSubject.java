package com.cipher.pattern.observer.custom;

/**
 * 气象站类
 * 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 * Created by cipher on 2017/9/8.
 */
public class WeatherStationSubject extends Subject {

    private String weather;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
        // 状态改变时，通知观察者
        this.notifyObservers();
        this.notifyObservers(weather);
    }

}
