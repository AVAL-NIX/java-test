package 链表集合AA.链表中环的入口结点;

import common.ListNode;

import java.util.ArrayList;
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

    /**
     * 两个结论：
     * 1、设置指针，假如有环，他们最后一定相遇。
     * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode fast = pHead, slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = pHead;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                    if (fast == slow) {
                        break;
                    }
                }
                return fast;
            }
        }
        return fast;
    }
}