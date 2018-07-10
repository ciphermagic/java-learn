package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description: 给出exR1(6)的返回值
 * @Date: Created in 11:29 2018/7/10
 */
public class Ex16 {

    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        System.out.println(exR1(6)); // 311361142246
    }

}
