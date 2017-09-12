package com.cipher.pattern.chain;

/**
 * 销售副总裁，可以批准 50% 以内的折扣
 * <p>
 * Created by cipher on 2017/9/12.
 */
public class VicePresident extends PriceHandler {

    public void processDiscount(float discount) {
        if (discount <= 0.5f) {
            System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(), discount);
        } else {
            this.getSuccessor().processDiscount(discount);
        }
    }

}
