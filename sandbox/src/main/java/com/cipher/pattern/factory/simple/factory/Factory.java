package com.cipher.pattern.factory.simple.factory;

import com.cipher.pattern.factory.simple.product.BMW;
import com.cipher.pattern.factory.simple.product.BMW320;
import com.cipher.pattern.factory.simple.product.BMW523;

/**
 * 简单工厂类
 * Created by cipher on 2017/9/6.
 */
public class Factory {

    public BMW createBMW(int type) {
        switch (type) {
            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
            default:
                return null;
        }
    }

}
