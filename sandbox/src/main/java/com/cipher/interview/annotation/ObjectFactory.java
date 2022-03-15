package com.cipher.interview.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

/**
 * @author cipher
 */
@SuppressWarnings("unchecked")
public class ObjectFactory {

    public static <T> T newInstance(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Annotation[] annotations = clazz.getAnnotations();
        LinkedList<IAspect> aspects = new LinkedList<>();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Aspect) {
                Class<?> type = ((Aspect) annotation).type();
                IAspect aspect = (IAspect) (type.getConstructor().newInstance());
                aspects.push(aspect);
            }
        }

        T inst = clazz.getConstructor().newInstance();
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
            aspects.forEach(IAspect::before);
            Object result = method.invoke(inst);
            aspects.forEach(IAspect::after);
            return result;
        });
    }

    @Test
    public void test() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        IOrder order = ObjectFactory.newInstance(Order.class);
        order.pay();
        order.show();
    }

}
