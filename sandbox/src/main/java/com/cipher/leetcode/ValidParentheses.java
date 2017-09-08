package com.cipher.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 问题：
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * PS：
 * 验证括号的位置是否正确
 * Created by cipher on 2017/9/8.
 */
public class ValidParentheses {

    // 初始化 map，用于存放括号的对应关系
    public static final Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        // 初始化栈，用于后续判断括号的对应关系
        Stack<Character> stack = new Stack<Character>();
        // 遍历字符串的每个字符
        for (Character c : s.toCharArray()) {
            // 如果字符是开始括号，把关闭括号入栈
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            }
            // 否者判断关闭括号
            // 如果栈是空的，代表没有开始括号，返回 false；
            // 如果栈不是空，判断栈顶的字符（出栈）与当前字符是否相同，不相同返回 false；
            else if (stack.isEmpty() || !stack.pop().equals(c)) {
                return false;
            }
        }
        // 如果栈为空，表示括号全部匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

}
