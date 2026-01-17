package main.java.leetcode;

import main.java.common.ListNode;

/*
Question: 83. Remove Duplicates from Sorted List
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {
        var obj = new RemoveDuplicatesFromSortedList_83();
        System.out.println(ListNode.printListNode(obj.deleteDuplicates(ListNode.generateList(new int[]{1, 1, 2, 3, 3}))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = prev.next;
        while (curr != null) {
            if (curr.val == prev.val) {
                curr = curr.next;
                continue;
            }
            prev.next = curr;
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr;
        return head;
    }
}
