package com.cipher.data_structure.G_Heap_and_Priority_Queue;

import com.cipher.data_structure.B_Stacks_and_Queues.queue.Queue;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 10:37 2018/11/15
 */
public class PriorityQueue<E extends Comparable> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

}
