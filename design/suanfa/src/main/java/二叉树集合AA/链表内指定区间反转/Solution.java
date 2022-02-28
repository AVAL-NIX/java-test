package 二叉树集合AA.链表内指定区间反转;

import common.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode next = head;
        ListNode newHead = null;
        while (m > 1) {
            if (next == null) {
                return head;
            }
            if (m == 2) {
                newHead = next;
            }
            next = next.next;

            m--;

        }
        ListNode mNode = next;

        next = head;
        while (n >= 1) {
            if (next == null) {
                return head;
            }
            next = next.next;

            n--;
        }
        ListNode nNode = next;

        ListNode resultNode = reverseAB(mNode, nNode);
        mNode.next = next;
        if (newHead != null) {
            newHead.next = resultNode;
        } else {
            return resultNode;
        }
        return head;
    }

    public ListNode reverseAB(ListNode a, ListNode b) {
        ListNode pre = null;
        while (a != b) {
            ListNode next = a.next;
            a.next = pre;
            pre = a;
            a = next;
        }
        return pre;
    }

}