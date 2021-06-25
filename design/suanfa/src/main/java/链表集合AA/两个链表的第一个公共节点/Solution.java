package 链表集合AA.两个链表的第一个公共节点;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currHeadA = headA;
        while (currHeadA != null) {
            ListNode equalsHeadA = currHeadA;
            boolean isMark = false;
            ListNode currHeadB = headB;
            while (currHeadB != null && equalsHeadA != null) {
                if (currHeadB != equalsHeadA) {
                    currHeadB = currHeadB.next;
                }else{
                    isMark = true;
                    break;
                }
            }
            //标记， 如果全相等 则返回
            if (isMark) {
                return currHeadA;
            }
            currHeadA = currHeadA.next;
        }
        return null;
    }
}