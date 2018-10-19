package com.cipher.algorithm_visualization.G_Build_Maze.random_1;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * @Author: CipherCui
 * @Description: 随机队列
 * @Date: Created in 13:53 2018/10/9
 */
public class RandomQueue<E> {

    private ArrayList<E> queue;

    public RandomQueue() {
        this.queue = new ArrayList<>();
    }

    public void add(E e) {
        this.queue.add(e);
    }

    public E remove() {
        if (CollectionUtils.isEmpty(queue)) {
            throw new IllegalArgumentException("There's no element to remove in Random Queue");
        }
        int randIndex = (int) (Math.random() * queue.size());
        E randElement = queue.get(randIndex);
        queue.set(randIndex, queue.get(queue.size() - 1));
        queue.remove(queue.size() - 1);
        return randElement;
    }

    public int size() {
        return queue.size();
    }

    public boolean empty() {
        return CollectionUtils.isEmpty(queue);
    }

}
