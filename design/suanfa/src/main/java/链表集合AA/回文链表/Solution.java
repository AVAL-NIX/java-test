package 链表集合AA.回文链表;

import common.ListNode;

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

    /**
     * 双指针法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        left = head;
        return tranverse(head);
    }

    // 左侧指针
    ListNode left;

    private boolean tranverse(ListNode right) {
        if (right == null)
            return true;
        boolean res = tranverse(right.next);

        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        if (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果为奇数，还要在进一步
        if (fast != null) {
            slow = slow.next;
        }
        //开始模仿左右指针
        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null && left !=null) {
            if (right.val != left.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        return  pre;
    }

}
