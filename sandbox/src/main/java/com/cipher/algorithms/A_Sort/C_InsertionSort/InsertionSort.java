package com.cipher.algorithms.A_Sort.C_InsertionSort;

import com.cipher.algorithms.A_Sort.B_SelectionSort.SelectionSort;

import static com.cipher.algorithms.A_Sort.SortTestHelper.*;

/**
 * 插入排序 O(n^2)
 * 从第 1 个元素开始，依次判断此元素与之前元素的大小，
 * 如果比前元素小，就把前元素往后挪一个位置，否则终止循环，把该元素放到最后终止的位置
 * 重要性质：提前终止内层循环，在近乎有序的数组中效率最高
 * Created by cipher on 2017/10/12.
 */
public class InsertionSort {

    public static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            // 寻找元素 arr[i] 合适的插入位置
            int x = data[i];
            // j 保存元素 x 应该插入的位置
            int j;
            for (j = i; j >= 1 && x < (data[j - 1]); j--) {
                data[j] = data[j - 1];
            }
            data[j] = x;
        }
    }

    public static void main(String[] args) {
        int[] data1 = generateRandomArray(20000, 1, 100000);
        int[] data2 = copy(data1);
        testSort(InsertionSort.class, data1);
        testSort(SelectionSort.class, data2);
    }

}
