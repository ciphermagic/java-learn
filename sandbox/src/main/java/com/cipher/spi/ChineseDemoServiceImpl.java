package com.cipher.spi;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:39 2018/9/12
 */
public class ChineseDemoServiceImpl implements DemoService {

    @Override
    public String sayHi(String msg) {
        return "你好, " + msg;
    }

}
