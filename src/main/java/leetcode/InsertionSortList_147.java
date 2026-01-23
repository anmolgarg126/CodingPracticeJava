package main.java.leetcode;

import main.java.common.ListNode;

/*
Question: 147. Insertion Sort List
Link: https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList_147 {
    public static void main(String[] args) {
        var obj = new InsertionSortList_147();
        System.out.println(ListNode.printListNode(obj.insertionSortList(ListNode.generateList(new int[]{4, 2, 1, 3}))));
//        System.out.println(ListNode.printListNode(obj.insertionSortList(ListNode.generateList(new int[]{-1, 5, 3, 4, 0}))));
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = temp;
        }
        return dummy.next;
    }
}
