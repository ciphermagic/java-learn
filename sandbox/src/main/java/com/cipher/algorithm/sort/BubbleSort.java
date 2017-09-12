package com.cipher.algorithm.sort;

/**
 * 冒泡排序
 * 1、从第一个元素开始，逐次于后一个元素比较，如果大于后一个元素，则两元素交换位置
 * 2、第一步完成后，最大的元素会沉到最后。重复以上步骤，循环 n-1 次
 * <p>
 * 比较次数：
 * (n-1) + (n-2) + ... + 1，一共 n*(n-1)/2
 * <p>
 * 交换次数：
 * 最坏的情况，每次比较都要交换，n*(n-1)/2
 * 最好的情况，不需要交换，0
 * 平均是 n*(n-1)/4
 * <p>
 * 时间复杂度：
 * 比较次数+交换次数 = n*(n-1)/2 + n*(n-1)/4 = O(n*n)
 * Created by cipher on 2017/9/12.
 */
public class BubbleSort {

    public static void sort(int[] data) {
        int total = 0;
        // 循环 n-1 次，下标从 1 开始
        for (int i = 1; i < data.length; i++) {
            // 循环 n-i 次
            for (int j = 0; j < data.length - i; j++) {
                total++;
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 2, 1};
        sort(data);
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

}
