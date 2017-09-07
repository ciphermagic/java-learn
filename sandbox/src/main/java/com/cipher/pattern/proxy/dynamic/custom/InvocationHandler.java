package com.cipher.pattern.proxy.dynamic.custom;

import java.lang.reflect.Method;

/**
 * 自定义处理器
 * Created by cipher on 2017/9/6.
 */
public interface InvocationHandler {

    void invoke(Object o, Method m) throws Throwable;

}
