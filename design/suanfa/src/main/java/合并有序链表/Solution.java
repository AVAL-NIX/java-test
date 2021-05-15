package 合并有序链表;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode l1Next, l2Next, newListNode;
        l1Next = l1;
        l2Next = l2;
        if (l1Next.val > l2Next.val) {
            newListNode = l2Next;
            l2Next = l2Next.next;
        } else {
            newListNode = l1Next;
            l1Next = l1Next.next;
        }

        while (l1Next != null && l2Next != null) {
            ListNode temp = newListNode.next;
            if (l1Next != null && l2Next == null) {
                temp = l1Next;
                l1Next = l1Next.next;
            } else if (l1Next == null && l2Next != null) {
                temp = l2Next;
                l2Next = l2Next.next;
            } else if (l1Next != null && l2Next != null) {
                if (l1Next.val > l2Next.val) {
                    temp = l2Next;
                    l2Next = l2Next.next;
                } else {
                    temp = l1Next;
                    l1Next = l1Next.next;
                }
            }
            newListNode.next = temp;
        }

        return newListNode;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            ListNode next = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (next != null) {
                stringBuilder.append(next.val + ",");
                next = next.next;
            }
            return stringBuilder.toString();
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode3;
        listNode3.next = listNode4;

        listNode2.next = listNode5;

        System.out.println(new Solution().mergeTwoLists(listNode, listNode2).toString());
    }


}


