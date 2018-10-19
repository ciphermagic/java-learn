package com.cipher.algorithm_visualization.E_Sort.quick.simple;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:53 2018/9/19
 */
public class QuickSortDataSimple {

    public enum Type {
        Default,
        NearlyOrdered
    }

    public int[] numbers;
    public int l, r;
    public int curPivot;
    public int curElement;
    public boolean[] fixedPivot;

    public QuickSortDataSimple(int N, int randomBound, Type dataType) {
        numbers = new int[N];
        fixedPivot = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * randomBound) + 1;
            fixedPivot[i] = false;
        }
        if (dataType == Type.NearlyOrdered) {
            Arrays.sort(numbers);
            int swapTimes = (int) (0.01 * N);
            for (int i = 0; i < swapTimes; i++) {
                int a = (int) (Math.random() * N);
                int b = (int) (Math.random() * N);
                swap(a, b);
            }
        }
    }

    public QuickSortDataSimple(int N, int randomBound) {
        this(N, randomBound, Type.Default);
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
