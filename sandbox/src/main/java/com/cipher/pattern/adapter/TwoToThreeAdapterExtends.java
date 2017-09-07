package com.cipher.pattern.adapter;

/**
 * 使用【继承】方式实现适配器模式
 * 二相转三相适配器
 * Created by cipher on 2017/9/7.
 */
public class TwoToThreeAdapterExtends extends GBTwoSocket implements ThreePlugIf {

    public void powerFromThree() {
        System.out.println("转换");
        this.powerByTwo();
    }

}
