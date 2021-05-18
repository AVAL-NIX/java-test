package 链表集合AA.环形链表2;

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
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        //如果快指针后面的值为空。 说明没有环
        if(fast == null || fast.next ==null){
            return null;
        }
        //否则有环
        //fast一定比slow走了2倍路程。 所以slow == fast就是环开始的地方
        slow = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
