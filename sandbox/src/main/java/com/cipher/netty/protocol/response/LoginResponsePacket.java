package com.cipher.netty.protocol.response;

import com.cipher.netty.protocol.Packet;

import static com.cipher.netty.constant.Command.LOGIN_RESPONSE;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:00 2019/3/19
 */
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
