package 链表集合AA.删除有序链表中重复的元素;

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
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int currValue = curr.val;
                ListNode temp = curr;
                while (temp != null && temp.val == currValue) {
                    temp = temp.next;
                }
                curr.next = temp;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}