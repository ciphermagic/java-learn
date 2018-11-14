package com.cipher.data_structure.B_Stacks_and_Queues.queue;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 15:08 2018/10/23
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
