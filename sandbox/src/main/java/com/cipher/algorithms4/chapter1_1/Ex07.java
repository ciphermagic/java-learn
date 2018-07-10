package com.cipher.algorithms4.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: CipherCui
 * @Description: 分别给出以下代码段打印出得值
 * @Date: Created in 9:43 2018/7/10
 */
public class Ex07 {

    public static void A() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t); // 3.00009
    }

    public static void B() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum); // 499500
    }

    public static void C() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        StdOut.println(sum); // 10000
    }

    public static void main(String[] args) {
        A();
        B();
        C();
    }
}
