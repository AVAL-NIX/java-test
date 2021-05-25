package 链表集合AA.两个链表生成相加链表;

import common.ListNode;

import java.util.List;

/*
假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
给定两个这种链表，请生成代表两个整数相加值的结果链表。
例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。

 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode headr1 = revers(head1);
        ListNode headr2 = revers(head2);
        ListNode currHead = new ListNode(-1);
        ListNode newHead = currHead;
        boolean isUp = false;
        while (headr1 != null && headr2 != null) {
            int v = headr1.val + headr2.val;
            if (isUp) {
                v += 1;
            }
            isUp = false;
            if (v >= 10) {
                v %= 10;
                isUp = true;
            }
            newHead.val = v;
            newHead.next = new ListNode(-1);
            newHead = newHead.next;
            //
            headr1 = headr1.next;
            headr2 = headr2.next;

        }
        while (headr1 != null) {
            int v = isUp?  headr1.val+1:  headr1.val;
            isUp = false;
            if (v >= 10) {
                v %= 10;
                isUp = true;
            }
            newHead.val = v;
            newHead.next = new ListNode(-1);
            newHead = newHead.next;

            headr1 = headr1.next;
        }
        while (headr2 != null) {
            int v = isUp?  headr2.val+1:  headr2.val;
            isUp = false;
            if (v >= 10) {
                v %= 10;
                isUp = true;
            }
            newHead.val = v;
            newHead.next = new ListNode(-1);
            newHead = newHead.next;

            headr2 = headr2.next;
        }
        if(isUp){
            newHead.val = 1;
            ListNode result = revers(currHead);
            return result;
        }else{
            ListNode result = revers(currHead);
            return result.next;
        }

    }

    ListNode revers(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
