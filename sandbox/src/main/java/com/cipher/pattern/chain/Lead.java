package com.cipher.pattern.chain;

/**
 * 销售小组长，可以批准 15% 以内的折扣
 * <p>
 * Created by cipher on 2017/9/12.
 */
public class Lead extends PriceHandler {

    public void processDiscount(float discount) {
        if (discount <= 0.15f) {
            System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(), discount);
        } else {
            this.getSuccessor().processDiscount(discount);
        }
    }

}
