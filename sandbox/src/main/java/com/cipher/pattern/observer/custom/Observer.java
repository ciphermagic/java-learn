package com.cipher.pattern.observer.custom;

/**
 * 观察者接口，定义一个更新的方法
 * Created by cipher on 2017/9/8.
 */
public interface Observer {

    /**
     * 【拉模型】
     * 更新的方法
     *
     * @param subject 传入目标对象，方便获取目标对象的数据
     */
    void update(Subject subject);

    /**
     * 【推模型】
     * 更新的方法
     *
     * @param content 只传入目标对象的某些信息
     */
    void updateByPush(String content);

}
