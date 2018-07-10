package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description: 计算机用这段程序在一个小时之内能够得到F(N)结果的最大N值是多少？开发F(N)的一个更好的实现，用数组保存已经计算过的值。
 * @Date: Created in 11:30 2018/7/10
 */
public class Ex19 {

    public static long F(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return F(N - 1) + F(N - 2);
    }

    public static long[] F2(int N) {
        long[] a = new long[N + 1];
        if (N == 0) {
            return a;
        }
        a[1] = 1;
        if (N == 1) {
            return a;
        }
        for (int i = 2; i <= N; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a;
    }

    public static void main(String[] args) {
//        for (int N = 0; N < 100; N++) {
//            System.out.println(N + " " + F(N));
//        }
        long[] a = F2(10);
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + " " + a[i]);
        }
    }

}
