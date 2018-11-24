package com.cipher.data_structure.G_Heap_and_Priority_Queue;

import java.util.Random;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 10:55 2018/10/31
 */
public class Main {

    public static double testHeap(Integer[] testData, boolean isHeap) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        // create max heap
        if (isHeap) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (Integer num : testData) {
                maxHeap.add(num);
            }
        }
        // test max heap
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("Test MaxHeap completed.");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt();
        }
        double time1 = testHeap(testData, false);
        System.out.println("without heapify: " + time1 + " s");
        double time2 = testHeap(testData, true);
        System.out.println("with heapify: " + time2 + " s");
    }

}
