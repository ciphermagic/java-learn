package com.cipher.pattern.observer.special;

/**
 * 观察者接口，定义一个更新的方法
 * Created by cipher on 2017/9/8.
 */
public interface Observer {

    /**
     * 更新的方法
     *
     * @param subject 传入目标对象，方便获取目标对象的数据
     */
    void update(Subject subject);

    /**
     * 根据目标对象判断是否感兴趣
     *
     * @param subject
     * @return
     */
    boolean isInterest(Subject subject);

}
