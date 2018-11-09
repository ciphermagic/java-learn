package com.cipher.pattern.template;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:42 2018/11/8
 */
public class Main {

    public static void main(String[] args) {
        RefreshBeverage coffee = new Coffee();
        coffee.prepareBeverageTemplate();
        System.out.println();
        RefreshBeverage tea = new Tea();
        tea.prepareBeverageTemplate();
    }

}
