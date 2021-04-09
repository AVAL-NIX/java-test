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
 *
 *   * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 *      * 你能给出空间复杂度的解法么？
 */
public class Solution3 {

    /**
     * 双指针解法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(3);

        ListNode listNode1 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode;

        System.out.println(hasCycle(listNode));

    }


    public static class ListNode {
         
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
