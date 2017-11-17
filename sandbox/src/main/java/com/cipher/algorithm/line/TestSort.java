package com.cipher.algorithm.line;

import java.util.Arrays;

import static com.cipher.algorithm.line.SortTestHelper.*;

/**
 * Created by cipher on 2017/9/12.
 */
public class TestSort {

    private static void merge(Comparable[] data, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(data, l, r + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (l > mid) {
                data[k] = aux[j - l];
                j++;
            } else if (j > r) {
                data[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                data[k] = aux[i - l];
                i++;
            } else {
                data[k] = aux[j - l];
                j++;
            }
        }
    }

    private static void _sort(Comparable[] data, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        _sort(data, l, mid);
        _sort(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    public static void sort(Comparable[] data) {
        _sort(data, 0, data.length - 1);
    }

    public static void main(String[] args) {
        Integer[] data = generateRandomArray(10, 1, 10);
        printArray(data);
        testSort(TestSort.class, data);
        printArray(data);
    }

}
