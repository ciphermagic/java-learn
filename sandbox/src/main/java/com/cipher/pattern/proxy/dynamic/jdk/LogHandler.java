package com.cipher.pattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 日志处理器（实现代理的业务逻辑）
 * Created by cipher on 2017/9/6.
 */
public class LogHandler implements InvocationHandler {

    // 被代理对象，不需要知道类型
    private Object target;

    public LogHandler(Object target) {
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
        System.out.println("日志开始......");
        // 执行被代理类的方法
        Object o = method.invoke(target);
        System.out.println("日志结束......");
        return o;
    }

}
