package com.cipher.data_structure.B_Stacks_and_Queues.queue;

import com.cipher.data_structure.A_Arrays.Array;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 15:12 2018/10/23
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            res.append(i == array.getSize() - 1 ? "" : ", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
