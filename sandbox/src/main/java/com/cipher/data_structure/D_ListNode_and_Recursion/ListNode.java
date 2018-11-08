package com.cipher.data_structure.D_ListNode_and_Recursion;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 10:10 2018/10/25
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("HEAD ");
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
