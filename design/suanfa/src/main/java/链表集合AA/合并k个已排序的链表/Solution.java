package 链表集合AA.合并k个已排序的链表;


import common.ListNode;

import java.util.ArrayList;

/**
 * TODO .这题不会. .
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return fenzhi(lists, 0, lists.size() - 1);
    }

    private ListNode fenzhi(ArrayList<ListNode> lists, int left, int right) {
        if (left == right) {
            return lists.get(left);
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        return sum(fenzhi(lists, left, mid), fenzhi(lists, mid + 1, right));
    }

    private ListNode sum(ListNode one, ListNode two) {
        if (one == null)
            return two;
        if (two == null)
            return one;
        ListNode newResult = new ListNode(0);
        ListNode curr = newResult;
        while (one != null && two != null) {
            if (one.val > two.val) {
                curr.next = two;
                two = two.next;
            } else {
                curr.next = one;
                one = one.next;
            }
            curr = curr.next;
        }
        curr.next = one == null ? two : one;
        return newResult.next;
    }
}