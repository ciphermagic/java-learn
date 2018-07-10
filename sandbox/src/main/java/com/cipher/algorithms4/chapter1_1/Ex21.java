package com.cipher.algorithms4.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:30 2018/7/10
 */
public class Ex21 {

    public static void main(String[] args) {
        System.out.println("Please input count:");
        int count = StdIn.readInt();
        String[] names = new String[count];
        int[] nums1 = new int[count];
        int[] nums2 = new int[count];
        System.out.println("Please input info:");
        for (int i = 0; i < count; i++) {
            names[i] = StdIn.readString();
            nums1[i] = StdIn.readInt();
            nums2[i] = StdIn.readInt();
            System.out.println("---------------");
        }
        for (int i = 0; i < count; i++) {
            System.out.printf("%s|%d|%d|%.3f",
                    names[i],
                    nums1[i],
                    nums2[i],
                    (float) nums1[i] / nums2[i]);
            System.out.println();
        }
    }

}
