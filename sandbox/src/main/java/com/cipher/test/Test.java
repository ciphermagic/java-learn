package com.cipher.test;

import net.jodah.typetools.TypeResolver;

import java.util.function.Consumer;

public class Test {

    public Foo getFoo() {
        Foo foo = new Foo();
        foo.setAge(18);
        foo.setName("cipher");
        return foo;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Result<Foo> data = test.get((t) -> t.setName("aaa"));
        System.out.println();
    }

    private <T> Result<T> get(Consumer<T> consumer) {
        Class<?> aClass = TypeResolver.resolveRawArgument(Consumer.class, consumer.getClass());

        return null;
    }


}




