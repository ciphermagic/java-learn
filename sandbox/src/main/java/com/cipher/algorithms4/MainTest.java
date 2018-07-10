package com.cipher.algorithms4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 15:18 2018/7/9
 */
public class MainTest {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts("E:\\data\\tinyW.txt");
        Arrays.sort(whitelist);
        for (Integer key : In.readInts("E:\\data\\tinyT.txt")) {
            if (rank(key, whitelist) < 0) {
                System.out.println(key);
            }
        }
    }

}
