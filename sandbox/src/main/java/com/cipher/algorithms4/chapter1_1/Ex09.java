package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description: 编写一段代码，将一个正整数N用二进制表示并转换为一个String类型的值s。
 * @Date: Created in 9:43 2018/7/10
 */
public class Ex09 {

    public static void main(String[] args) {
        String s = "";
        int N = 10;
        for (int i = N; i > 0; i /= 2) {
            s = (i % 2) + s;
        }
        System.out.println(s);
        System.out.println(Integer.toBinaryString(N));
    }

}
