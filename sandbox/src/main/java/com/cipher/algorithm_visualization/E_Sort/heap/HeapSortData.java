package com.cipher.algorithm_visualization.E_Sort.heap;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:44 2018/9/21
 */
public class HeapSortData {

    private int[] numbers;
    public int heapIndex;   // numbers[heapIndex...N) 已经排好序

    public HeapSortData(int N, int randomBound) {
        numbers = new int[N];
        heapIndex = N;
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * randomBound) + 1;
        }
    }

    public int N() {
        return numbers.length;
    }

    public int get(int index) {
        return numbers[index];
    }

    public void swap(int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

}
