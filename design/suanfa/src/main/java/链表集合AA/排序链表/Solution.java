package 链表集合AA.排序链表;

import common.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        //至少要2个元素
        if(head == null|| head.next == null){
            return head;
        }
        //快慢指针找中点
        ListNode fast = head.next , slow = head;
        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //中间节点
        ListNode temp = slow.next;
        //断开, 将列表切成2段
        slow.next = null;
        //递归调用此方法，进行排序
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        //排序
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while (left !=null && right!=null){
            if(left.val < right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return newHead.next;
    }
}
