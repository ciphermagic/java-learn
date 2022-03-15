package com.cipher.interview.proxy;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author cipher
 */
@SuppressWarnings("unchecked")
public interface Aspect {

    /**
     * before
     */
    void before();

    /**
     * after
     */
    void after();

    /**
     * getProxy
     *
     * @param cls     cls
     * @param aspects aspects
     * @param <T>     t
     * @return T
     * @throws NoSuchMethodException     NoSuchMethod Exception
     * @throws InvocationTargetException InvocationTarget Exception
     * @throws InstantiationException    Instantiation Exception
     * @throws IllegalAccessException    IllegalAccess Exception
     */
    static <T> T getProxy(Class<T> cls, String... aspects) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Aspect> aspectInsts = Arrays.stream(aspects).map(name -> {
                    try {
                        Class<?> clazz = Class.forName(name);
                        return (Aspect) clazz.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).filter(Objects::nonNull)
                .collect(Collectors.toList());
        T inst = cls.getConstructor().newInstance();
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), (o, m, args) -> {
            for (Aspect aspect : aspectInsts) {
                aspect.before();
            }
            Object result = m.invoke(inst);
            for (Aspect aspect : aspectInsts) {
                aspect.after();
            }
            return result;
        });
    }

}
