package com.cipher.leetcode;

/**
 * 判断一个整数是不是回文数字，如1221
 * Created by cipher on 2017/9/7.
 */
public class Palindrome {

    public static boolean isPalindrome(int x) {
        // 如果数字是负数或最后一位是 0 （不包括 0），不是回文
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 计算反数
        int rev = 0;
        // 只需要计算一半的反数，当反数大于 x 时，表示已经计算完成
        while (x > rev) {
            rev = rev * 10 + x % 10;
            // x 递减 10 倍。即 x 去掉个位上的数字，进入下一次循环
            x = x / 10;
        }
        // 如果原来数字的位数是偶数位，比较 x 和 rev 是否相同
        // 如果位数是奇数位，例如 131，得到的 x 是 1，rev 是 13，即 rev 会比 x 多一位，因此需要把 rev 整除 10
        return (x == rev) || (x == rev / 10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(14341));
    }

}
