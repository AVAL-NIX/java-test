package 链表集合AA.删除链表的倒数第n个节点;

import common.ListNode;

/*

 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 用快慢指针
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slot = head;
        ListNode fast = head;
        //快指针先走
        while (n > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            n--;
        }
        //如果n的值等于链表的长度,直接返回去掉头结点的链表
        if (fast == null) {
            return head.next;
        }
        //同时走
        while (fast.next != null) {
            fast = fast.next;
            slot = slot.next;
        }
        //跳过倒数的第n个结点
        slot.next = slot.next.next;
        return head;
    }


}
