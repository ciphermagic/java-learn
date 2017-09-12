package com.cipher.pattern.chain;

/**
 * 销售人员，可以批准 5% 以内的折扣
 * <p>
 * Created by cipher on 2017/9/12.
 */
public class Sales extends PriceHandler {

    public void processDiscount(float discount) {
        if (discount <= 0.05f) {
            System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(), discount);
        } else {
            this.getSuccessor().processDiscount(discount);
        }
    }

}
