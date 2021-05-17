package 链表集合AA.链表中倒数第k个结点;

import common.ListNode;

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
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slot = pHead;
        //快指针先走
        while (k > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        //慢指针在走
        while (fast != null) {
            fast = fast.next;
            slot = slot.next;
        }
        return slot;
    }
}
