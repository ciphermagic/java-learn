package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description: 以下代码段会打印出什么结果
 * @Date: Created in 9:45 2018/7/10
 */
public class Ex12 {

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
            System.out.println(a[i]); // 0 1 2 3 4 4 3 2 1 0
        }
    }

}
