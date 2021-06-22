package 链表集合AA.删除链表的节点;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = head;
        ListNode pre = newHead;
        while(curr!=null){
            if(curr.val == val){
                pre.next = pre.next.next;
                break;
            }
            curr = curr.next;
            pre = pre.next;
        }
        return newHead.next;
    }
}