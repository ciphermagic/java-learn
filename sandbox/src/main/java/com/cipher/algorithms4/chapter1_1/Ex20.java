package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description: 编写一个递归的静态方法计算ln(N!)的值
 * @Date: Created in 11:30 2018/7/10
 */
public class Ex20 {

    public static double ln(int n) {
        if (n == 0) {
            return 0;
        }
        return Math.log(n) + ln(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(ln(10));
    }

}
