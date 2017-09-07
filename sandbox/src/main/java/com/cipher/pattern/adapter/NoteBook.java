package com.cipher.pattern.adapter;

/**
 * 笔记本类，本身具有三相插头
 * Created by cipher on 2017/9/7.
 */
public class NoteBook {

    private ThreePlugIf plug;

    public NoteBook(ThreePlugIf plug) {
        this.plug = plug;
    }

    // 使用插座充电
    public void charge() {
        plug.powerFromThree();
    }

    public static void main(String[] args) {
        // 插座
        GBTwoSocket socket = new GBTwoSocket();

        // 使用【组合】方式实现适配器模式
        ThreePlugIf plug = new TwoToThreeAdapter(socket);
        NoteBook nb = new NoteBook(plug);
        nb.charge();

        // 使用【继承】方式实现适配器模式
        ThreePlugIf plugByExtend = new TwoToThreeAdapterExtends();
        NoteBook nb2 = new NoteBook(plugByExtend);
        nb2.charge();
    }

}
