package com.cipher.leetcode;

/**
 * 问题：
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 * <p>
 * PS：把数字反转，要注意整型溢出的情况
 * Created by cipher on 2017/9/6.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        // 计算反数
        int result = 0;
        // x 递减 10 倍，所以 x 不等于 0，都要进入计算
        while (x != 0) {
            // 取 x 个位上的数字
            int tail = x % 10;
            // 上一循环的结果（即 x 原来的尾数）乘以 10，再加上现在的尾数
            int newResult = result * 10 + tail;
            // 把 newResult 还原为 result，判断是否相等，如果不相等表示溢出了
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            // newResult 赋值给 result，使得 result 可以累加
            result = newResult;
            // x 递减 10 倍。即 x 去掉个位上的数字，进入下一次循环
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int x1 = 123;
        int x2 = -123;
        int x3 = Integer.MAX_VALUE;
        System.out.println(reverse(x1)); // 321
        System.out.println(reverse(x2)); // -321
        System.out.println(reverse(x3)); // 0
    }

}
