package 链表集合AA.两数相加;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        boolean isUp = false;
        while(l1!=null && l2!=null){
            int val = l1.val + l2.val;
            if(isUp){
                val++;
            }
            isUp = false;
            if(val> 9){
                isUp = true;
                val %=10;
            }
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode temp = l1 == null ? l2 : l1;
        while(temp!=null){
            int val = temp.val;
            if(isUp){
                val++;
            }
            isUp = false;
            if(val> 9){
                isUp = true;
                val %=10;
            }
            curr.next = new ListNode(val);
            curr = curr.next;
            temp = temp.next;
        }
        if(isUp){
            curr.next = new ListNode(1);
        }
        return result.next;
    }
}