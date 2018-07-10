package com.cipher.algorithms4.chapter1_1;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:30 2018/7/10
 */
public class Ex23 {

    public static int rank(int[] a, int key, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(a, key, 0, mid - 1);
        }
        if (key > a[mid]) {
            return rank(a, key, mid + 1, hi);
        }
        return mid;
    }

    public static void whitelist(int[] whitelist, int[] p, String operate) {
        Arrays.sort(whitelist);
        for (int i = 0; i < p.length; i++) {
            int rank = rank(whitelist, p[i], 0, whitelist.length - 1);
            if (rank == -1 && operate.equals("+")) {
                System.out.println(p[i]);
            } else if (rank != -1 && operate.equals("-")) {
                System.out.println(whitelist[rank]);
            }
        }
    }

    public static void main(String[] args) {
        int[] whitelist = {1, 2, 3, 4};
        int[] p = {2, 4, 5};
        whitelist(whitelist, p, "-");
    }

}
