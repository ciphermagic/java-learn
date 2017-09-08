package com.cipher.leetcode;

/**
 * 问题：
 * Write a function to find the longest common prefix string amongst an array of strings.
 * PS：
 * 查找一个字符串数组的最长公共前缀，例如：["abc", "abcd12f", "abi"]，返回 "ab"
 * Created by cipher on 2017/9/8.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 以第一个字符串为前缀
        String prefix = strs[0];
        // 依次与每一个字符串判断
        for (int i = 1; i < strs.length; i++) {
            // 只要 prefix 不是 strs[i] 的前缀，就把 prefix 去掉一位，直到 prefix 为空
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "aq", "aw"};
        System.out.println(longestCommonPrefix(strs));
    }

}
