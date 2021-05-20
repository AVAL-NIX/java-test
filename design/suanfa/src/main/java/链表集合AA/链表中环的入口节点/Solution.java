package 链表集合AA.链表中环的入口节点;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //因为等于 所以slow 从头开始
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                    if (slow == fast) {
                        break;
                    }
                }
                return fast;
            }
        }
        return null;
    }
}
