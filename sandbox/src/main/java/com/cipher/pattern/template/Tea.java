package com.cipher.pattern.template;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:42 2018/11/8
 */
public class Tea extends RefreshBeverage {

    @Override
    protected void brew() {
        System.out.println("用80度的热水浸泡茶叶5分钟");
    }

    @Override
    protected boolean isCondiments() {
        return false;
    }

}
