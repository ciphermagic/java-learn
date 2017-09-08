package com.cipher.pattern.observer.special;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，它知道它的观察者，并提供添加和删除观察者的接口
 * Created by cipher on 2017/9/8.
 */
public abstract class Subject {

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
            // 感兴趣才调用更新方法
            if (o.isInterest(this)) {
                o.update(this);
            }
        }
    }

}
