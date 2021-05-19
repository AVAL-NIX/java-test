package 链表集合AA.两个链表的第一个公共结点;

import common.ListNode;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode head1 , head2;
        head1 = pHead1;
        head2 = pHead2;
        while (head1!=null){
            while (head2!=null){
                if(head1 == head2){
                    return head1;
                }
                head2 = head2.next;
            }
            head1 = head1.next;
            head2 = pHead2;
        }
        return null;
    }
}
