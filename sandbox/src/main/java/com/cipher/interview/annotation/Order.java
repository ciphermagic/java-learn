package com.cipher.interview.annotation;

import org.junit.Test;

import java.lang.reflect.Proxy;

@Aspect(type = TimeUsageAspect.class)
public class Order implements IOrder {

    int state = 0;

    @Override
    public void pay() throws InterruptedException {
        Thread.sleep(50);
        this.state = 1;
    }

    @Override
    public void show() {
        System.out.println("order status:" + this.state);
    }

    @Test
    public void testProxy() throws InterruptedException {
        IOrder order = new Order();
        IOrder proxy = (IOrder) Proxy.newProxyInstance(Order.class.getClassLoader(), new Class[]{IOrder.class}, (proxy1, method, args) -> {
            System.out.println("before invoke method:" + method);
            return method.invoke(order);
        });
        proxy.pay();
    }

}
