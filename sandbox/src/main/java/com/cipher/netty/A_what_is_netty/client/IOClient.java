package com.cipher.netty.A_what_is_netty.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 15:51 2018/9/28
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }

}
