package com.cipher.algorithm.line;

import static com.cipher.algorithm.line.SortTestHelper.*;

/**
 * Created by cipher on 2017/9/12.
 */
public class TestSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = generateRandomArray(10, 1, 10);
        printArray(data);
        testSort(TestSort.class, data);
        printArray(data);
    }

}
