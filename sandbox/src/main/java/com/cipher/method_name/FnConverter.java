package com.cipher.method_name;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

public class FnConverter {

    @FunctionalInterface
    public interface Fn<T> extends Serializable {
        Object apply(T source);
    }

    public static <T> String convertFnToString(Fn<T> fn) {
        return fnToFieldName(fn);
    }

    public static String fnToFieldName(Fn fn) {
        try {
            Method method = fn.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(Boolean.TRUE);
            SerializedLambda serializedLambda = (SerializedLambda) method.invoke(fn);
            return serializedLambda.getImplMethodName();
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        String fieldName = FnConverter.convertFnToString(Foo::getBar);
        System.out.println("方法名：" + fieldName);
    }

}
