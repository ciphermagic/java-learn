package com.cipher.algorithms4.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * @Author: CipherCui
 * @Description: 请看以下函数，mystery(2, 25)和mystery(3, 11)的返回值是多少？给定正整数a和b，mystery(a, b)计算的结果是什么？
 * 将代码中的+替换为*并将return 0改为return 1，然后回答相同的问题。
 * @Date: Created in 11:30 2018/7/10
 */
public class Ex18 {

    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }

    public static int mystery2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mystery(a * a, b / 2);
        }
        return mystery(a * a, b / 2) * a;
    }

    public static void main(String[] args) {
        int a = StdIn.readInt();
        int b = StdIn.readInt();

        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));
        System.out.println(mystery(a, b) == a * b);

        System.out.println(mystery2(2, 25));
        System.out.println(mystery2(3, 11));
        System.out.println(mystery2(a, b) == Math.pow(a, b));
    }

}
