package com.cipher.pattern.adapter;

/**
 * 使用【组合】方式实现适配器模式
 * 集成目标接口 ThreePlugIf，组合被适配对象 GBTwoSocket
 * 二相转三相适配器
 * Created by cipher on 2017/9/7.
 */
public class TwoToThreeAdapter implements ThreePlugIf {

    private GBTwoSocket twoSocket;

    public TwoToThreeAdapter(GBTwoSocket socket) {
        this.twoSocket = socket;
    }

    public void powerFromThree() {
        System.out.println("转换");
        this.twoSocket.powerByTwo();
    }

}
