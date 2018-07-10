package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description: 编写一个静态方法lg()，接受一个整形参数N，返回不大于log2N的最大整数。不要使用Math库。
 * @Date: Created in 11:29 2018/7/10
 */
public class Ex14 {

    public static int lg(int N) {
        int count = 0;
        while (N != 0) {
            N = N / 2;
            count++;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        int N = 8;
        System.out.println(lg(N));
        System.out.println(Math.log(N)/Math.log(2));
    }

}
