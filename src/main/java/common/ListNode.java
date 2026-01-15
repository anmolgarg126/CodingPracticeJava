package main.java.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static String printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode dummy = head;
        while (dummy != null) {
            sb.append(dummy.val).append("->");
            dummy = dummy.next;
        }
        return sb.substring(0, sb.length() - 2);
    }

    public static ListNode generateList(int[] arr) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = n1;
        for (int i : arr) {
            n2.next = new ListNode(i);
            n2 = n2.next;
        }
        return n1.next;
    }

}
