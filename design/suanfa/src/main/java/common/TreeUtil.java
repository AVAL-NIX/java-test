package common;

/**
 * @author zhengxin
 * @date 2021/6/3
 */
public class TreeUtil {

    public static ListNode BuildListNode(int n) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i <= n; i++) {
            ListNode temp = new ListNode(i);
            curr.next = temp;
            curr = curr.next;
        }
        return head.next;
    }

    public static ListNode BuildListNode(int[] n) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 0; i < n.length; i++) {
            ListNode temp = new ListNode(n[i]);
            curr.next = temp;
            curr = curr.next;
        }
        return head.next;
    }
}
