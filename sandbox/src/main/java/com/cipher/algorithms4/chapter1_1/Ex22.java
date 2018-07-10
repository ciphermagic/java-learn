package com.cipher.algorithms4.chapter1_1;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:30 2018/7/10
 */
public class Ex22 {

    public static int rank(int[] a, int key, int lo, int hi, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.println("lo=" + lo + ", hi=" + hi);
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(a, key, lo, mid - 1, depth + 1);
        }
        if (key > a[mid]) {
            return rank(a, key, mid + 1, hi, depth + 1);
        }
        return mid;
    }

    public static void main(String[] args) {
        int key = 8;
        int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 12};
        Arrays.sort(a);
        System.out.println(rank(a, key, 0, a.length - 1, 0));
    }

}
