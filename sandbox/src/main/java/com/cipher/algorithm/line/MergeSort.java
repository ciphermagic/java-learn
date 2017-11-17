package com.cipher.algorithm.line;

import java.util.Arrays;

import static com.cipher.algorithm.line.SortTestHelper.copy;
import static com.cipher.algorithm.line.SortTestHelper.generateRandomArray;
import static com.cipher.algorithm.line.SortTestHelper.testSort;

/**
 * 归并排序 O(nlogn)
 * O(nlogn)：把 n 个元素逐次 2 分，需要 log(n) 次，对于每一级的元素，采取 O(n) 的算法，就得到 O(nlogn) 的时间复杂度。
 * 把原数组逐次 2 分，把 2 分后的数组根据规则（需要定义 3 个索引：归并数组索引，两个下级数组的索引）合并到上一级的数组中。
 * Created by cipher on 2017/11/7.
 */
public class MergeSort {

    public static void sort(Comparable[] data) {
        _sort(data, 0, data.length - 1);
    }

    // 递归使用归并排序,对 data[l...r] 的范围进行排序
    private static void _sort(Comparable[] data, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        _sort(data, l, mid);
        _sort(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    // 将 data[l...mid] 和 data[mid+1...r] 两部分进行归并
    private static void merge(Comparable[] data, int l, int mid, int r) {
        // 复制一份原数组
        Comparable[] aux = Arrays.copyOfRange(data, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        // aux 数组与原数组有 l 个位置的偏移量
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 如果左半部分元素已经全部处理完毕
            if (i > mid) {
                data[k] = aux[j - l];
                j++;
            }
            // 如果右半部分元素已经全部处理完毕
            else if (j > r) {
                data[k] = aux[i - l];
                i++;
            }
            // 左半部分所指元素 < 右半部分所指元素
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                data[k] = aux[i - l];
                i++;
            }
            // 左半部分所指元素 >= 右半部分所指元素
            else {
                data[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data1 = generateRandomArray(100000, 1, 20000);
        Integer[] data2 = copy(data1);
        Integer[] data3 = copy(data1);
        Integer[] data4 = copy(data1);
        Integer[] data5 = copy(data1);
//        testSort(BubbleSort.class, data1);
//        testSort(SelectionSort.class, data2);
//        testSort(InsertionSort.class, data3);
        testSort(ShellSort.class, data4);
        testSort(MergeSort.class, data5);
    }

}
