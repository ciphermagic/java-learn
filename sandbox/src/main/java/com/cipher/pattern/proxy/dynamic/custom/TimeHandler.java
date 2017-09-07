package com.cipher.pattern.proxy.dynamic.custom;

import java.lang.reflect.Method;

/**
 * 时间记录处理器
 * Created by cipher on 2017/9/6.
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    public void invoke(Object o, Method m) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("汽车开始行驶......");
        m.invoke(target);
        long end = System.currentTimeMillis();
        System.out.println("汽车结束行驶......行驶时间：" + (end - start) + "毫秒");
    }

}
