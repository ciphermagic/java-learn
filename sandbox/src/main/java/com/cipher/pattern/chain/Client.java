package com.cipher.pattern.chain;

/**
 * 责任链模式测试类
 * Created by cipher on 2017/9/12.
 */
public class Client {

    public static void main(String[] args) {
        Custom custom = new Custom(PriceHandlerFactory.createPriceHandler());
        custom.requestDiscount(0.31f);
    }

}
