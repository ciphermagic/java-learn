package com.cipher.pattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 时间记录处理器（实现代理的业务逻辑）
 * Created by cipher on 2017/9/6.
 */
public class TimeHandler implements InvocationHandler {

    // 被代理对象，不需要知道类型
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  生成的代理对象
     * @param method 被代理对象的方法
     * @param args   方法参数
     * @return 方法的返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("汽车开始行驶......");
        // 执行被代理类的方法
        Object o = method.invoke(target);
        long end = System.currentTimeMillis();
        System.out.println("汽车结束行驶......行驶时间：" + (end - start) + "毫秒");
        return o;
    }

}
