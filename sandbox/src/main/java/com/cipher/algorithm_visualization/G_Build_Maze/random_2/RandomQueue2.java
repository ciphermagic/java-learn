package com.cipher.algorithm_visualization.G_Build_Maze.random_2;

import org.springframework.util.CollectionUtils;

import java.util.LinkedList;

/**
 * @Author: CipherCui
 * @Description: 随机队列2
 * @Date: Created in 13:53 2018/10/9
 */
public class RandomQueue2<E> {

    private LinkedList<E> queue;

    private static final double FACTOR = 0.5;

    public RandomQueue2() {
        this.queue = new LinkedList<>();
    }

    public void add(E e) {
        if (Math.random() < FACTOR) {
            queue.addFirst(e);
        } else {
            queue.addLast(e);
        }
    }

    public E remove() {
        if (CollectionUtils.isEmpty(queue)) {
            throw new IllegalArgumentException("There's no element to remove in Random Queue");
        }
        if (Math.random() > FACTOR) {
            return queue.removeFirst();
        } else {
            return queue.removeLast();
        }
    }

    public int size() {
        return queue.size();
    }

    public boolean empty() {
        return CollectionUtils.isEmpty(queue);
    }

}
