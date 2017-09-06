package com.cipher.pattern.factory.abs;

import com.cipher.pattern.factory.abs.factory.FactoryBMW;
import com.cipher.pattern.factory.abs.factory.FactoryBMW320;
import com.cipher.pattern.factory.abs.factory.FactoryBMW523;

/**
 * 抽象工厂模式客户端
 * Created by cipher on 2017/9/6.
 */
public class Customer {

    public static void main(String[] args) {
        FactoryBMW factoryBMW320 = new FactoryBMW320();
        factoryBMW320.createEngie();
        factoryBMW320.createAircondition();

        FactoryBMW factoryBMW523 = new FactoryBMW523();
        factoryBMW523.createEngie();
        factoryBMW523.createAircondition();
    }

}
