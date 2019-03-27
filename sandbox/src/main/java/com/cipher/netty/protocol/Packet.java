package com.cipher.netty.protocol;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:26 2019/3/19
 */
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}
