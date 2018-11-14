package com.cipher.data_structure.B_Stacks_and_Queues.stack;

import com.cipher.data_structure.A_Arrays.Array;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:50 2018/10/23
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        this(10);
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
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
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            res.append(i == array.getSize() - 1 ? "" : ", ");
        }
        res.append("] top");
        return res.toString();
    }
}
