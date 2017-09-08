package com.cipher.pattern.observer.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，它知道它的观察者，并提供添加和删除观察者的接口
 * Created by cipher on 2017/9/8.
 */
public class Subject {

    // 用于保存注册的观察者对象
    private List<Observer> observers = new ArrayList<Observer>();

    // 添加观察者
    public void attach(Observer... os) {
        if (os == null || os.length == 0) return;
        for (Observer o : os) {
            this.observers.add(o);
        }
    }

    // 删除观察者
    public void detach(Observer o) {
        observers.remove(o);
    }

    // 通知所有注册的观察者对象
    protected void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    // 【推模型】通知所有注册的观察者对象
    protected void notifyObservers(String content) {
        for (Observer o : observers) {
            o.updateByPush(content);
        }
    }

}
