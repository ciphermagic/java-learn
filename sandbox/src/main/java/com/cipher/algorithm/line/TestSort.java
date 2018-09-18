package com.cipher.algorithm.line;

import java.util.Arrays;

import static com.cipher.algorithm.line.SortTestHelper.*;

/**
 * Created by cipher on 2017/9/12.
 */
public class TestSort {

    public static void sort(int[] nums) {
        _sort(nums, 0, nums.length - 1);
    }

    private static void _sort(int[] nums, int l, int r) {
        System.out.println("Deal with [ " + l + " , " + r + " ]");
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        _sort(nums, l, mid);
        _sort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(nums, l, r + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = aux[j - l];
                j++;
            } else if (j > r) {
                nums[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                nums[k] = aux[i - l];
                i++;
            } else {
                nums[k] = aux[j - l];
                j++;
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
