package com.cipher.algorithms4.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: CipherCui
 * @Description: 下面这段程序会打印什么
 * @Date: Created in 9:42 2018/7/10
 */
public class Ex06 {

    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
        // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
    }

}
