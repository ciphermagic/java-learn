package com.cipher.pattern.chain;

/**
 * 客户，请求折扣
 * Created by cipher on 2017/9/12.
 */
public class Custom {

    private PriceHandler priceHandler;

    public Custom(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDiscount(float discount) {
        this.priceHandler.processDiscount(discount);
    }

}
