package com.cipher.spi;

import java.util.ServiceLoader;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:41 2018/9/12
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<DemoService> serviceLoader = ServiceLoader.load(DemoService.class);
        for (DemoService demoService : serviceLoader) {
            System.out.println(demoService.getClass().getName() + " >>>>>> " + demoService.sayHi("World"));
        }
    }

}
