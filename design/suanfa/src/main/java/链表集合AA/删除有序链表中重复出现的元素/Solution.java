package 链表集合AA.删除有序链表中重复出现的元素;

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
        //维护curr的上一个节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode preWhile = pre;
        //维护curr
        ListNode curr = pre.next;
        while (curr != null && curr.next != null) {
            int currValue = curr.val;
            if (currValue == curr.next.val) {
                while (curr != null && curr.val == currValue) {
                    curr = curr.next;
                }
                preWhile.next = curr;
            } else {
                curr = curr.next;
                //这里有问题。
                preWhile = preWhile.next;
            }

        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode5;
        System.out.println(new 链表集合AA.删除有序链表中重复出现的元素.Solution().deleteDuplicates(listNode));
    }
}