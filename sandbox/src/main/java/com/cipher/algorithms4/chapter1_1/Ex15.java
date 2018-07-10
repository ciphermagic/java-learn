package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description: 编写一个静态方法histogram()，接受一个整型数组a[]和一个整数M为参数并返回一个大小为M的数组，其中第i个元素的值为整数i在参数数组中出现的次数。
 * 如果a[]中的值均在0到M-1之间，返回数组中所有元素之和应该和a.length相等。
 * @Date: Created in 11:29 2018/7/10
 */
public class Ex15 {

    public static int[] histogram(int[] a, int m) {
        int[] b = new int[m];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0 && a[i] <= m - 1) {
                b[a[i]]++;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3};
        int[] result = histogram(a, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%3d", result[i]);
        }
    }

}
