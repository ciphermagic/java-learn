package com.cipher.algorithms4.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: CipherCui
 * @Description: 编写一个程序，从命令行得到三个整数参数。如果它们都相等则打印equal，否则打印not equal。
 * @Date: Created in 9:23 2018/7/10
 */
public class Ex03 {

    public static void main(String[] args) {
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        if ((a == b) && (a == c)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

}
