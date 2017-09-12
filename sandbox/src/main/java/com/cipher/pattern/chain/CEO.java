package com.cipher.pattern.chain;

/**
 * CEO
 * <p>
 * Created by cipher on 2017/9/12.
 */
public class CEO extends PriceHandler {

    public void processDiscount(float discount) {
        if (discount <= 0.55f) {
            System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(), discount);
        } else {
            System.out.format("%s拒绝了折扣：%.2f%n", this.getClass().getName(), discount);
        }
    }

}
