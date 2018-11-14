package com.cipher.data_structure.C_Linked_List;

import com.cipher.data_structure.B_Stacks_and_Queues.stack.ArrayStack;
import com.cipher.data_structure.B_Stacks_and_Queues.stack.Stack;

import java.util.Random;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:13 2018/10/22
 */
public class Main {

    private static double testStack(Stack<Integer> q, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        System.out.println(testStack(new ArrayStack<>(), opCount));
        System.out.println(testStack(new LinkedListStack<>(), opCount));
    }

}
