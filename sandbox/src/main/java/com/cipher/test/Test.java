package com.cipher.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Function;

/**
 * Created by cipher on 2017/9/14.
 */
public class Test {

    public String getName() {
        return "123";
    }

    public static void main(String[] args) throws IOException {
        Function<Test, Object> getName = Test::getName;
        String apply = (String) getName.apply(new Test());
        System.out.println(apply);
    }

}
