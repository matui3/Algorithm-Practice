package LeetCode;

public class ListNode {

    public int val;
    public ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val) {
        this(val, null);
    }

    ListNode() {
        this(0, null);
    }
}
