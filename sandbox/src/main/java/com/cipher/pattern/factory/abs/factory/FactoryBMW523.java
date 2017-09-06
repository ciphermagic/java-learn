package com.cipher.pattern.factory.abs.factory;

import com.cipher.pattern.factory.abs.product.*;

/**
 * 为宝马523系列生产配件
 * Created by cipher on 2017/9/6.
 */
public class FactoryBMW523 implements FactoryBMW {

    public Engine createEngie() {
        return new EngineB();
    }

    public Aircondition createAircondition() {
        return new AirconditionB();
    }

}
