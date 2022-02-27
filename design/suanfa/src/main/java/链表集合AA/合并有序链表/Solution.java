package 链表集合AA.合并有序链表;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

import common.ListNode;

public class Solution {
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode newListNode = new ListNode(0);
        ListNode cur = newListNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null)? l2 : l1;
        return newListNode.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode3;
        listNode3.next = listNode4;

        listNode2.next = listNode5;

        System.out.println(new Solution().mergeTwoLists(listNode, listNode2).toString());
    }


}


