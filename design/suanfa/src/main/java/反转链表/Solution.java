package 反转链表;/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

import java.util.Stack;


/**
 * 双链表解决
 * • 建立2个对象， 一个标记上一个对象， 一个标记下一个对象
 * • whlie循环判断当前节点是否为空
 * • 保存当前节点下一个节点
 * • 把上一个对象赋值给当前节点的下一个节点
 * • 然后把当前节点给上一个节点 （头插法）
 * • 然后下一个节点赋值给上一个节点
 * 栈解决
 * • 先循环压入栈， 栈符合先进后出的规则
 * • 在组成链表
 *
 * 递归解决
 *
 *
 */
public class Solution {

    public static ListNode ReverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = ReverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }



    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode pre = null;
        while (head != null) {
            s.add(head);
            head = head.next;
        }
        while(!s.isEmpty()) {
            ListNode t = s.pop();
            pre.next = t;
            pre = pre.next;
        }
        pre.next = null;
        return pre;
    }



    public ListNode ReverseList2(ListNode head) {
        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(3);

        ListNode listNode1 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode3.next = listNode;

        ListNode a = ReverseList3(listNode);
        System.out.println(a);
    }
    public  static class ListNode {
        public int val;
        public ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
