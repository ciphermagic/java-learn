package com.cipher.pattern.chain;

/**
 * 价格处理人抽象类，负责处理客户的折扣申请
 * Created by cipher on 2017/9/12.
 */
public abstract class PriceHandler {

    /**
     * 直接后继，用于传递请求
     */
    private PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    public PriceHandler getSuccessor() {
        return this.successor;
    }

    /**
     * 处理折扣申请
     *
     * @param discount
     */
    public abstract void processDiscount(float discount);

}
