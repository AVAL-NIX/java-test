package 链表集合AA.删除链表中重复的结点;

import common.ListNode;

import java.util.List;

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode curr = pre.next;
        while (curr !=null){
            ListNode old = pre.next;
            while(curr!=null && curr.val == old.val){
                curr = curr.next;
            }
            pre.next = curr;
        }
        return head.next;
    }
}