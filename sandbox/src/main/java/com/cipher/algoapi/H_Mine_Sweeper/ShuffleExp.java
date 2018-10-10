package com.cipher.algoapi.H_Mine_Sweeper;

/**
 * @Author: CipherCui
 * @Description: 验证算法的随机性
 * @Date: Created in 15:34 2018/10/10
 */
public class ShuffleExp {

    // 模拟次数
    private int N;
    // 格子数
    private int n;
    // 雷数
    private int m;

    public ShuffleExp(int N, int n, int m) {
        this.N = N;
        this.n = n;
        this.m = m;
    }

    public void run() {
        int freq[] = new int[n];
        int arr[] = new int[n];
        for (int i = 0; i < N; i++) {
            reset(arr);
            shuffle(arr);
            for (int j = 0; j < n; j++) {
                freq[j] += arr[j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + " : " + (double) freq[i] / N);
        }
    }

    private void shuffle(int[] arr) {
        for (int i = 0; i < m; i++) {
            int x = (int) (Math.random() * n);
            swap(arr, i, x);
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void reset(int[] arr) {
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }
        for (int i = m; i < n; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        ShuffleExp shuffleExp = new ShuffleExp(10000000, 10, 5);
        shuffleExp.run();
    }

}
