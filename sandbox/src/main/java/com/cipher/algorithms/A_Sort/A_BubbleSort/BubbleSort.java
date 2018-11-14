package com.cipher.algorithms.A_Sort.A_BubbleSort;

import static com.cipher.algorithms.A_Sort.SortTestHelper.*;

/**
 * 冒泡排序 O(n^2)
 * 循环 n 趟，每一趟依次比较每个元素与下一个元素的大小，把最大的元素“沉”到最后
 * Created by cipher on 2017/9/12.
 */
public class BubbleSort {

    public static void sort(int[] data) {
        // 循环 n 趟
        for (int i = 0; i < data.length; i++) {
            // 每一趟，下标从 1 开始递增，依次与前一个元素比较大小，大的交换到后面
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1]>(data[j])) {
                    swap(data, j - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = generateRandomArray(10000, 1, 10000);
//        printArray(data);
        testSort(BubbleSort.class, data);
//        printArray(data);
    }

}
