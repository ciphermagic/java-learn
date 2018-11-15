package com.cipher.data_structure.G_Heap_and_Priority_Queue;

import java.util.*;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class LeetCode347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.add(key);
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }


    public static void main(String[] args) {
        LeetCode347 leetCode = new LeetCode347();
        List<Integer> integers = leetCode.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        System.out.println(integers);
    }

}
