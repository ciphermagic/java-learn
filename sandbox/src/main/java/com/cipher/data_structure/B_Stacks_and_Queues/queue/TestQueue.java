package com.cipher.data_structure.B_Stacks_and_Queues.queue;

import com.cipher.data_structure.C_Linked_List.LinkedListQueue;

import java.util.Random;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 16:35 2018/10/23
 */
public class TestQueue {

    private static double testQueue(Queue<Integer> q, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        System.out.println(testQueue(new ArrayQueue<>(), opCount));
        System.out.println(testQueue(new LoopQueue<>(), opCount));
        System.out.println(testQueue(new LinkedListQueue<>(), opCount));
    }

}
