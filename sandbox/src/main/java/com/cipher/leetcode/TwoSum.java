package com.cipher.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题：
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * Created by cipher on 2017/9/6.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 取差值
            int key = target - nums[i];
            // 判断差值是否已经存在
            if (map.containsKey(key)) {
                // 是：返回相应的下标
                return new int[]{map.get(key), i};
            } else {
                // 否：把当前的值和下标放入 map 中
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result != null && result.length > 0) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("null");
        }
    }

}
