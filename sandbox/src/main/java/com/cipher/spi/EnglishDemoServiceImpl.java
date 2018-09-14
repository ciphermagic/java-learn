package com.cipher.spi;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:38 2018/9/12
 */
public class EnglishDemoServiceImpl implements DemoService {

    @Override
    public String sayHi(String msg) {
        return "Hello, " + msg;
    }

}
