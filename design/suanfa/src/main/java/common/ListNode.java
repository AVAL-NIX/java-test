package common;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            str.append(curr.val);
            str.append(",");
            curr = curr.next;
        }
        return str.toString();
    }
}
