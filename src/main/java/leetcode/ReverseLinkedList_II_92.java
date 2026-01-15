package main.java.leetcode;

import main.java.common.ListNode;

public class ReverseLinkedList_II_92 {
    public static void main(String[] args) {
        var obj = new ReverseLinkedList_II_92();
        ListNode head = ListNode.generateList(new int[]{1, 2, 3, 4, 5});
        System.out.println(ListNode.printListNode(obj.reverseBetween(head, 2, 4)));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode leftPrevious = dummy;
        ListNode curr = head;
        for (int i = 0; i < left - 1; i++) {
            leftPrevious = curr;
            curr = curr.next;
            i++;
        }

        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        leftPrevious.next.next = curr;
        leftPrevious.next = prev;

        return dummy.next;
    }
}
