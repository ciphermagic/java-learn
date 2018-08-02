package com.cipher.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cipher on 2017/9/14.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6379);
        Socket socket = server.accept();
        byte[] chars = new byte[64];
        socket.getInputStream().read(chars);
        System.out.println(new String(chars));
    }

}
