package com.cipher.algorithms4.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * @Author: CipherCui
 * @Description: 如果double类型的变量x和y都严格位于0和1之间则打印true，否则打印false。
 * @Date: Created in 9:37 2018/7/10
 */
public class Ex05 {

    public static void main(String[] args) {
        double a = StdIn.readDouble();
        double b = StdIn.readDouble();
        if ((a >= 0.0 && a <= 1.0) && (b >= 0.0 && b <= 1.0)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

}
