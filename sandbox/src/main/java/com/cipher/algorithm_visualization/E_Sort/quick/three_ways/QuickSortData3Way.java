package com.cipher.algorithm_visualization.E_Sort.quick.three_ways;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:53 2018/9/19
 */
public class QuickSortData3Way {

    public enum Type {
        Default,
        NearlyOrdered,
        Identical
    }

    private int[] numbers;
    public int l, r;
    public boolean[] fixedPivots;
    public int curPivot;
    public int curL, curR;

    public QuickSortData3Way(int N, int randomBound, Type dataType) {
        numbers = new int[N];
        fixedPivots = new boolean[N];
        int lBound = 1;
        int rBound = randomBound;
        if (dataType == Type.Identical) {
            int avg = (lBound + rBound) / 2;
            lBound = avg;
            rBound = avg;
        }
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * (rBound - lBound + 1)) + lBound;
            fixedPivots[i] = false;
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

    public QuickSortData3Way(int N, int randomBound) {
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
