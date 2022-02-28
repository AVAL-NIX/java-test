package 链表集合AA.链表内指定区间反转;

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
        ListNode mHead = null;
        while (m > 1) {
            if (m == 2) {
                mHead = next;
            }
            next = next.next;
            m--;
        }
        ListNode mNode = next;

        next = head;
        while (n >= 1) {
            next = next.next;
            n--;
        }
        ListNode nNode = next;
        ListNode resultNode = reverseAB(mNode, nNode);
        // m 已经从头反转到尾部了, 所以补充一下next
        mNode.next = next;
        // 如果m 之前的头不为空,则m
        if (mHead != null) {
            mHead.next = resultNode;
        } else {
            return resultNode;
        }
        return head;
    }

    ListNode reverseAB(ListNode a, ListNode b) {
        ListNode pre = null, next = null, curr = a;
        while (b != curr) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    /**
     * TODO  这种比较好
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);  // 哑巴节点，指向链表的头部
        dummy.next = head;
        ListNode pre = dummy;  // pre 指向要翻转子链表的前驱节点
        for (int i = 1; i < m; ++i) {
            pre = pre.next;
        }
        ListNode mHead = pre.next;  // head指向翻转子链表的首部
        for (int i = m; i < n; ++i) {
            ListNode next = mHead.next;
            // head节点连接next节点之后链表部分，也就是向后移动一位
            mHead.next = next.next;
            // next节点移动到需要反转链表部分的首部
            next.next = pre.next;
            // pre继续为需要反转头节点的前驱节点
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode5;
        System.out.println(new Solution().reverseBetween2(listNode, 2, 4));
    }
}