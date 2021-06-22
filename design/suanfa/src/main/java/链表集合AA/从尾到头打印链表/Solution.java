package 链表集合AA.从尾到头打印链表;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode pre = null;
        while(head !=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        while (pre!=null){
            res.add(pre.val);
            pre = pre.next;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] reversePrint2(ListNode head) {
        ListNode pre = null;
        int count = 0;
        while(head !=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }
        int[] r = new int[count];
        count = 0;
        while (pre!=null){
            r[count] = (pre.val);
            count++;
            pre = pre.next;
        }
        return r;
    }
}