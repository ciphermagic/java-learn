package com.cipher.pattern.template;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:33 2018/11/8
 */
public abstract class RefreshBeverage {

    public final void prepareBeverageTemplate() {
        // 将水煮沸
        boilWater();
        // 泡制饮料
        brew();
        // 将饮料倒入杯中
        pourInCup();
        if (isCondiments()) {
            // 加入调味料
            addCondiments();
        }
    }

    protected boolean isCondiments() {
        return true;
    }

    private void boilWater() {
        System.out.println("将水煮沸");
    }

    protected abstract void brew();

    private void pourInCup() {
        System.out.println("将饮料倒入杯中");
    }

    protected void addCondiments() {

    }

}
