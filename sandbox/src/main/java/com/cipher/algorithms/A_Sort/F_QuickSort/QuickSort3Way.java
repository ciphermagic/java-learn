package com.cipher.algorithms.A_Sort.F_QuickSort;

import static com.cipher.algorithms.A_Sort.SortTestHelper.*;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:13 2018/9/21
 */
public class QuickSort3Way {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = (int) (Math.random() * (r - l) + 1) + l;
        swap(nums, l, p);
        int v = nums[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (nums[i] < v) {
                swap(nums, i, lt + 1);
                i++;
                lt++;
            } else if (nums[i] > v) {
                swap(nums, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(nums, l, lt);
        sort(nums, l, lt - 1);
        sort(nums, gt, r);
    }

    public static void main(String[] args) {
        int[] data = generateRandomArray(10, 1, 10);
        printArray(data);
        testSort(QuickSort3Way.class, data);
        printArray(data);
    }

}
