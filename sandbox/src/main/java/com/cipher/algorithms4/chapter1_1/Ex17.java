package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description: 找出以下递归函数的问题
 * @Date: Created in 11:29 2018/7/10
 */
public class Ex17 {

    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) {
            return "";
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(exR2(3)); // StackOverflowError
    }

}
