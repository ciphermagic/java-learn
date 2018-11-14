package com.cipher.algorithms.A_Sort;

import static com.cipher.algorithms.A_Sort.SortTestHelper.*;

/**
 * Created by cipher on 2017/9/12.
 */
public class TestSort {

    public static void sort(int[] nums) {
        _sort(nums, 0, nums.length - 1);
    }

    private static void _sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        _sort(nums, l, p - 1);
        _sort(nums, p + 1, r);
    }

    private static int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int j = l;
        for (int i = l + 1; i < nums.length; i++) {
            if (nums[i] < v) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, l, j);
        return j;
    }


    public static void main(String[] args) {
        int[] data = generateRandomArray(1000000, 1, 10);
//        printArray(data);
        testSort(TestSort.class, data);
//        printArray(data);
    }

}
