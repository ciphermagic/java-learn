package com.cipher.algorithms4.chapter1_1;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * @Author: CipherCui
 * @Description: 编写一段程序，打印出一个二维布尔数组的内容。其中，使用*表示真，空格表示假。打印出行号和列号。
 * @Date: Created in 9:44 2018/7/10
 */
public class Ex11 {

    public static void main(String[] args) {
        boolean[][] a = {
                {true, false, true},
                {false, false, true, true},
                {true, false, true}};

        System.out.print(" ");
        int max = a[0].length;
        for (int i = 1; i < a.length; i++) {
            if (a[i].length > max) {
                max = a[i].length;
            }
        }
        for (int i = 0; i < max; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(i);
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
