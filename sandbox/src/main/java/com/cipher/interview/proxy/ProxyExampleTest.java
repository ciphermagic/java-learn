package com.cipher.interview.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author cipher
 */
public class ProxyExampleTest {

    @Test
    public void testProxy() throws InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        IOrder order = Aspect.getProxy(Order.class, "com.cipher.interview.proxy.TimeUsageAspect");
        order.pay();
        order.show();
    }

}
