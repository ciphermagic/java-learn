package com.cipher.algorithm_visualization.E_Sort.insertion;

import java.util.Arrays;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:20 2018/9/17
 */
public class InsertionSortData {

    public enum Type {
        Default,
        NearlyOrdered
    }

    private int[] numbers;
    // [0...orderedIndex) 是有序的
    public int orderedIndex = -1;
    // 当前正在处理的元素的索引
    public int currentIndex = -1;

    public InsertionSortData(int N, int randomBound, Type dataType) {
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * randomBound) + 1;
        }
        if (dataType == Type.NearlyOrdered) {
            Arrays.sort(numbers);
            int swapTimes = (int) (0.02 * N);
            for (int i = 0; i < swapTimes; i++) {
                int a = (int) (Math.random() * N);
                int b = (int) (Math.random() * N);
                swap(a, b);
            }
        }
    }

    public InsertionSortData(int N, int randomBound) {
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
