package com.cipher.netty.protocol.request;

import com.cipher.netty.constant.Command;
import com.cipher.netty.protocol.Packet;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:27 2019/3/19
 */
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
