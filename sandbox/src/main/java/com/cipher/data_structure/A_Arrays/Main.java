package com.cipher.data_structure.A_Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:13 2018/10/22
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for (Integer i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.addLast(10);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
    }

}
