package 链表集合AA.重排链表;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode newHead = reverse(mid);


        while(newHead != null){
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
        ListNode n = null;
    }

    //反转链表
    public ListNode reverse(ListNode head){
        if(head == null)
            return head;
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }
        return tail;
    }

    public void reorderList2(ListNode head) {
//        if (head == null || head.next == null || head.next.next == null) {
//            return;
//        }
//        ListNode fast = head, slow = head;
//        while (fast.next != null && fast.next.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode midNode = null;
//        if (fast.next == null) {
//            midNode = slow;
//        }else{
//            midNode =  slow.next;
//        }
//        slow.next = null;
//
//        ListNode newHead = reverse(midNode);
////        sumList(head, newHead);
//        while (newHead != null) {
//            ListNode next = newHead.next;
//            newHead.next = head.next;
//            head.next = newHead;
//            head = newHead.next;
//            newHead = next;
//        }
//        while(newHead != null){
//            ListNode temp = newHead.next;
//            newHead.next = head.next;
//            head.next = newHead;
//            head = newHead.next;
//            newHead = temp;
//        }
        System.out.println(head.toString());
    }

    // 找中间节点
    public ListNode midList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null) {
            return slow;
        }
        return slow.next;
    }

    // 反转链表
    public ListNode reverse2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next; // next储存了此时头结点的下一个结点
            head.next = pre;  // 头结点的下一个结点指向 tail
            pre = head; // 此时的头结点则变为尾结点
            head = next;  // 刚刚储存起来的结点则为头结点
        }
        return pre;
    }


    //合并两个链表
    public ListNode sumList(ListNode s1, ListNode s2) {
        while (s2 != null) {
            ListNode next = s2.next;
            s2.next = s1.next;
            s1.next = s2;
            s1 = s2.next;
            s2 = next;
        }
        return s1;
    }


    /**
     * 解法一 线性表
     * <p>
     * 我们都知道链表的缺点是查询效率低，每一次都需要从头开始遍历。所以如果按照题目的要求组成新链表，要去得到最后一个节点，就得从头将链表遍历一次，这样反复操作，直到将原来的链表改变到题目要求的链表。这样很明显是非常耗时间的。、
     * <p>
     * 由于有了上面的分析，直到了这一缺点，我们就可以想到与链表齐名的数组了。
     * <p>
     * 我们知道数组想访问某一个元素的时候，可以通过下标直接去访问它，这不就是我们想要的吗？
     * <p>
     * 所以下面我们先来一个简单粗暴的方法，因为我们知道ArrayList的底层就是用数组实现的，所以我们将链表储存在一个ArrayList中，然后利用双指针，一个指向最前面，一个指向最后面，依次访问并向题目要求的链表形式进行转换！
     */

    public void reorderList3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            //  eg:  1->2->3->4
            // 前面的节点的下一个节点指向最后的节点
            list.get(i).next = list.get(j); //  即 1->4
            i++; // 此时 i++ 则此时 list.get(i) 为原来前面节点的下一个节点   即节点2
            if (i == j) { // 若 链表长度为偶数的情况下 则会提前相遇，此时已达到题目要求，直接终止循环
                break;
            }
            list.get(j).next = list.get(i); //  4->2
            // 此时刚刚的例子则变为  1->4->2->3
            j--;
        }
        //最后一个节点的下一个节点为null
        list.get(i).next = null;
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
        new Solution().reorderList(listNode);
    }
}