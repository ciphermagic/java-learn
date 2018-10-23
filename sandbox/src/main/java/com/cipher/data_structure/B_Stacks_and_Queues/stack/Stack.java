package com.cipher.data_structure.B_Stacks_and_Queues.stack;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:53 2018/10/23
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();

}
