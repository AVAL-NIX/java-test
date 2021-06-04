package 链表集合AA.划分链表;

import common.ListNode;
import common.TreeUtil;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * @param head ListNode类
     * @param x    int整型
     * @return ListNode类
     */
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode curr1 = list1, curr2 = list2;
        ListNode curr = head;
        while (curr!=null){
            if(curr.val < x){
                //往前排
                curr1.next = curr;
                curr1  = curr1.next;
            }else{
                curr2.next = curr;
                curr2 = curr2.next;
            }
           curr =  curr.next;
        }
        //拼接2个链表
        curr1.next = list2.next;
        curr2.next = null;
        return list1.next;
    }

    public static void main(String[] args) {
        System.out.println(TreeUtil.BuildListNode(new int[]{1,4,3,2,5,2}));
        System.out.println(new Solution().partition(TreeUtil.BuildListNode(new int[]{1,4,3,2,5,2}), 3));
    }
}