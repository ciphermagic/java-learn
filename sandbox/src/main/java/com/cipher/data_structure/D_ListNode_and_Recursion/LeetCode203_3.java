package com.cipher.data_structure.D_ListNode_and_Recursion;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class LeetCode203_3 {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(head);
        ListNode result = removeElements(head, 6);
        System.out.println(result);
    }


}
