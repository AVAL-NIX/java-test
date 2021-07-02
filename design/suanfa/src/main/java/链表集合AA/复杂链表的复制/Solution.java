package 链表集合AA.复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // 拼接
        Node curr = head;
        while(curr!=null){
            Node t = new Node(curr.val);
            t.next = curr.next;
            curr.next = t;
            curr = t.next;
        }
        //互指
        curr = head;
        while (curr !=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        //拆分
        //新的起点
        curr = head.next;
        Node pre = head, res = head.next;
        while(curr.next != null) {
            pre.next = pre.next.next;
            curr.next = curr.next.next;
            pre = pre.next;
            curr = curr.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;
    }
    public Node copyRandomList2(Node head) {
        Map<Node,Node> hash = new HashMap<>();

        if(head == null) return null;
        // 拼接
        Node curr = head;
        while(curr!=null){
            hash.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        //互指
        curr = head;
        while (curr !=null){
            hash.get(curr).next = hash.get(curr.next);
            hash.get(curr).random = hash.get(curr.random);
            curr = curr.next;
        }
        return hash.get(head);
    }


}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}