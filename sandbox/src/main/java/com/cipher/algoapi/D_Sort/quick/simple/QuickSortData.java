package com.cipher.algoapi.D_Sort.quick.simple;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:53 2018/9/19
 */
public class QuickSortData {

    public int[] numbers;
    public int l, r;
    public int curPivot;
    public int curElement;
    public boolean[] fixedPivot;

    public QuickSortData(int N, int randomBound) {
        numbers = new int[N];
        fixedPivot = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * randomBound) + 1;
            fixedPivot[i] = false;
        }
    }

    public int N() {
        return numbers.length;
    }

    public int get(int index) {
        return numbers[index];
    }

    public void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
