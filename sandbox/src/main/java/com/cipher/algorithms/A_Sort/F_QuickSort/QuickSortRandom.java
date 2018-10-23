package com.cipher.algorithms.A_Sort.F_QuickSort;

import static com.cipher.algorithms.A_Sort.SortTestHelper.*;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:13 2018/9/21
 */
public class QuickSortRandom {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    private static int partition(int[] nums, int l, int r) {
        int p = (int) (Math.random() * (r - l) + 1) + l;
        swap(nums, p, l);
        int v = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] data = generateRandomArray(10, 1, 10);
        printArray(data);
        testSort(QuickSortRandom.class, data);
        printArray(data);
    }

}
