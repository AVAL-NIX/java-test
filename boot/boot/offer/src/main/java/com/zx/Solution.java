package com.zx;


public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode temp = null;
        ListNode tempPre = head;
        while (head.next != null) {
            temp = head;
            tempPre = head.next;
            tempPre.next = temp;

            head = head.next;
        }
        return tempPre;
    }
}
