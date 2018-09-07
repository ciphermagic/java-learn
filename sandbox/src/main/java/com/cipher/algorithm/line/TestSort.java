package com.cipher.algorithm.line;

import java.util.Arrays;

import static com.cipher.algorithm.line.SortTestHelper.*;

/**
 * Created by cipher on 2017/9/12.
 */
public class TestSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        int[] data = generateRandomArray(10, 1, 10);
        printArray(data);
        testSort(TestSort.class, data);
        printArray(data);
    }

}
