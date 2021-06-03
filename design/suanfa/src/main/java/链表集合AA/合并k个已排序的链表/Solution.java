package 链表集合AA.合并k个已排序的链表;


import common.ListNode;

import java.util.ArrayList;

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return fenzhi(lists, 0, lists.size() - 1);
    }

    private ListNode fenzhi(ArrayList<ListNode> lists, int l, int r) {
        if (l == r) {
            return lists.get(l);
        }
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        return sum(fenzhi(lists, l, mid), fenzhi(lists, mid + 1, r));
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