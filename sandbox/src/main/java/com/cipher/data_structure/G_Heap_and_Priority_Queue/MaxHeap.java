package com.cipher.data_structure.G_Heap_and_Priority_Queue;

import com.cipher.data_structure.A_Arrays.Array;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:33 2018/11/9
 */
public class MaxHeap<E extends Comparable> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("doesn't have parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

}
