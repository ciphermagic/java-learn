package com.cipher.test;

import java.io.IOException;

/**
 * Created by cipher on 2017/9/14.
 */
public class Test {

    public String getName() {
        return "123";
    }

    public static void main(String[] args) throws IOException {
        int a = 6 % 16;
        int b = 6 & 15;
        System.out.println(a);
        System.out.println(b);
    }

}
