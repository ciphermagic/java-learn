package com.cipher.data_structure.D_ListNode_and_Recursion;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 17:30 2018/10/25
 */
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = sum(arr);
        System.out.println(sum);
    }

}
