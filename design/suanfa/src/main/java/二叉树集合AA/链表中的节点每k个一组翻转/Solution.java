package 二叉树集合AA.链表中的节点每k个一组翻转;

import common.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (head == null) {
            return null;
        }
        //[a,b)
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newNode = reverseAB(a, b);
        a.next = reverseKGroup(b, k);
        return newNode;
    }

    public ListNode reverseAB(ListNode a, ListNode b) {
        ListNode pre = null;
        while (a != b) {
            ListNode next = a.next;
            a.next = pre;
            pre = a;
            a = next;
        }
        return pre;
    }
}