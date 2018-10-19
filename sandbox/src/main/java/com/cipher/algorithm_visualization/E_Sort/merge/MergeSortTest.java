package com.cipher.algorithm_visualization.E_Sort.merge;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:33 2018/9/18
 */
public class MergeSortTest {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1, 0);
    }

    private static void sort(int[] nums, int l, int r, int depth) {
        System.out.print(repeatCharacters('-', depth * 2));
        System.out.println("Deal with [ " + l + " , " + r + " ]");
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(nums, l, mid, depth + 1);
        sort(nums, mid + 1, r, depth + 1);
        merge(nums, l, mid, r);
    }

    private static String repeatCharacters(char character, int length) {
        StringBuilder s = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            s.append(character);
        }
        return s.toString();
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
        int[] nums = new int[8];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length - i;
        }
        sort(nums);
    }

}
