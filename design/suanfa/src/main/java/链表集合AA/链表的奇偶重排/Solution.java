package 链表集合AA.链表的奇偶重排;

import common.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode headWhile = newHead;
        ListNode old = new ListNode(0);
        ListNode oldWhile = old;
        int index = 1;
        while (head != null) {
            if (index % 2 == 0) {
                //偶数
                oldWhile.next = head;
                oldWhile = oldWhile.next;
            } else {
                //奇数
                headWhile.next = head;
                headWhile = headWhile.next;
            }
            head = head.next;
            index++;
        }
        oldWhile.next = null;

        headWhile.next = old.next;
        return newHead.next;
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
        System.out.println(new 链表集合AA.链表的奇偶重排.Solution().oddEvenList(listNode));
    }
}