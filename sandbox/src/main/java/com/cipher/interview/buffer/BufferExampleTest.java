package com.cipher.interview.buffer;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

/**
 * @author cipher
 */
public class BufferExampleTest {

    private static final long WORD_NUM = 1000000000;

    @Test
    public void gen() throws IOException {
        Random r = new Random();
        String fileName = "word";

        int bufferSize = 4 * 1024;
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName), bufferSize);

        long start = System.currentTimeMillis();

        for (int i = 0; i < WORD_NUM; i++) {
            for (int j = 0; j < 5; j++) {
                outputStream.write(97 + r.nextInt(5));
            }
            outputStream.write(' ');
        }
        outputStream.close();
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void testChinese() {
        String raw = "长坂桥头杀气生，横枪立马眼圆睁。一声好似轰雷震，独退曹家百万兵。";
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = charset.encode(raw).array();
        byte[] bytes2 = Arrays.copyOfRange(bytes, 0, 11);

        ByteBuffer bbuf = ByteBuffer.allocate(12);
        CharBuffer cbuf = CharBuffer.allocate(12);

        bbuf.put(bytes2);
        bbuf.flip();

        charset.newDecoder().decode(bbuf, cbuf, true);
        cbuf.flip();

        char[] tmp = new char[cbuf.length()];
        if (cbuf.hasRemaining()) {
            cbuf.get(tmp);
            System.out.println("here:" + new String(tmp));
        }

        System.out.format("limit-pos=%d\n", bbuf.limit() - bbuf.position());

        bytes2 = Arrays.copyOfRange(bbuf.array(), bbuf.position(), bbuf.limit());
    }

}
