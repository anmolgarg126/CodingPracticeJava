package main.java.leetcode;

import main.java.common.ListNode;

/*
Question: 328. Odd Even Linked List
Link: https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList_328 {
    public static void main(String[] args) {
        var obj = new OddEvenLinkedList_328();
        System.out.println(ListNode.printListNode(obj.oddEvenList(ListNode.generateList(new int[]{1, 2, 3, 4, 5}))));
        System.out.println(ListNode.printListNode(obj.oddEvenList(ListNode.generateList(new int[]{2,1,3,5,6,4,7}))));
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oddList = new ListNode(0);
        ListNode oddListHead = oddList;
        ListNode evenList = new ListNode(0, head);
        ListNode evenListHead = evenList;
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            if (i % 2 == 0) {
                evenListHead.next = curr;
                evenListHead = curr;
            } else {
                oddListHead.next = curr;
                oddListHead = curr;
            }
            curr = curr.next;
            i++;
        }
        oddListHead.next = null;
        evenListHead.next = oddList.next;
        return evenList.next;
    }
}
