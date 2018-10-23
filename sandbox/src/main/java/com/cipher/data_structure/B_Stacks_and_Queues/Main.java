package com.cipher.data_structure.B_Stacks_and_Queues;

import com.cipher.data_structure.B_Stacks_and_Queues.stack.ArrayStack;
import com.cipher.data_structure.B_Stacks_and_Queues.stack.Stack;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:13 2018/10/22
 */
public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
