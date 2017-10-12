package com.cipher.algorithm.line;

import java.lang.reflect.Method;

/**
 * 测试排序的帮助类
 * Created by cipher on 2017/9/14.
 */
public class SortTestHelper {

    private SortTestHelper() {
    }

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            // Math.random() 生成 [0, 1) 之间的随机数
            // Math.random() * (rangeR - rangeL + 1) 生成 [0, y-x] 之间的随机数
            // (Math.random() * (rangeR - rangeL + 1) + rangeL) 生成 [x, y] 之间的随机数
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            swap(arr, a, b);
        }
        return arr;
    }

    // 交换数组中两个元素的位置
    public static void swap(Comparable[] data, int i, int j) {
        Comparable temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 打印 arr 数组的所有内容
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }

    // 判断 arr 数组是否有序
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    // 测试 sortClassName 所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(Class sortClass, Comparable[] arr) {
        try {
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();
            boolean isSorted = isSorted(arr);
            System.out.println("[" + isSorted + "] " + sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 复制一个数组
    public static Integer[] copy(Integer[] arr) {
        Integer[] result = new Integer[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        return result;
    }

}
