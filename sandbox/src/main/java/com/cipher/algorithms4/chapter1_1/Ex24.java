package com.cipher.algorithms4.chapter1_1;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 11:30 2018/7/10
 */
public class Ex24 {

    public static int euclid(int p, int q) {
        System.out.printf("%d, %d", p, q);
        System.out.println();
        if (q == 0) {
            return p;
        }
        return euclid(q, p % q);
    }

    public static void main(String[] args) {
        System.out.println(">>> " + euclid(105, 24));
        System.out.println(">>> " + euclid(1111111, 1234567));
    }

}
