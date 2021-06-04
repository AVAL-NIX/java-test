package 链表集合AA.删除排序链表中的重复元素;

import common.ListNode;
import common.TreeUtil;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = newHead.next;
        while (curr != null && curr.next != null) {
            ListNode pre = curr;
            while (pre != null && pre.val == curr.val) {
                pre = pre.next;
            }
            curr.next = pre;
            curr = curr.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().deleteDuplicates(TreeUtil.BuildListNode(new int[]{1, 1, 2, 3, 3, 3, 3, 3})));
    }
}