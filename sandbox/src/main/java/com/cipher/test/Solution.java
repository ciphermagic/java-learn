package com.cipher.test;

import java.util.LinkedList;

class Solution {

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] hash = new int[128];
        for (char c : t.toCharArray()) {
            hash[c]--;
        }
        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < m; i++) {
            hash[s.charAt(i)]++;
            if (hash[s.charAt(i)] <= 0) {
                cnt++;
            }
            while (cnt == n && hash[s.charAt(j)] > 0) {
                hash[s.charAt(j++)]--;
            }
            if (cnt == n && ("".equals(res) || res.length() > i - j + 1)) {
                res = s.substring(j, i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String res = new Solution().minWindow("ADOBECODEBANC", "ABC");
        System.out.println();
    }
}
