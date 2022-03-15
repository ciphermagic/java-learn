package com.cipher.interview.proxy;

/**
 * @author cipher
 */
public class Order implements IOrder {

    int state = 0;

    @Override
    public void pay() throws InterruptedException {
        Thread.sleep(50);
        this.state = 1;
    }

    @Override
    public void show() {
        System.out.println("order status:" + this.state);
    }

}
