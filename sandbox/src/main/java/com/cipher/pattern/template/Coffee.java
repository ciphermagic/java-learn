package com.cipher.pattern.template;


/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:40 2018/11/8
 */
public class Coffee extends RefreshBeverage {

    @Override
    protected void brew() {
        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入糖和牛奶");
    }

}
