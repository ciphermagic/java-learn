package com.cipher.algorithms4.chapter1_1;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description: 编写一段代码，打印出一个M行N列的二维数组的转置（交换行和列）
 * @Date: Created in 11:29 2018/7/10
 */
public class Ex13 {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        for (int[] i : b) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
