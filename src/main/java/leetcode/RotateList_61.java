package main.java.leetcode;

import main.java.common.ListNode;

import static main.java.common.ListNode.printListNode;

/*
Question: 61. Rotate List
Link: https://leetcode.com/problems/rotate-list
 */
public class RotateList_61 {
    public static void main(String[] args) {
        var obj = new RotateList_61();
        obj.testCase1();
    }

    private void testCase1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        System.out.println(printListNode(rotateRight(l1, 2)));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int n = 1;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        k = k % n;
        if (k == 0) {
            return head;
        }

        // reverse full linked list
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }
        ListNode firstHead = reverse(head, end);

        // reverse First K elements
        ListNode firstEnd = firstHead;
        for (int i = 0; i < k - 1; i++) {
            firstEnd = firstEnd.next;
        }
//        System.out.println(printListNode(firstEnd));
        ListNode secondHead = firstEnd.next;
        ListNode first = reverse(firstHead, firstEnd);
//        System.out.println(printListNode(first));

        // reverse elements after k
        ListNode secondEnd = secondHead;
        while (secondEnd.next != null) {
            secondEnd = secondEnd.next;
        }
        ListNode second = reverse(secondHead, secondEnd);

        // attach second in the first end
        temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = second;
//        System.out.println(printListNode(second));
        return first;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            if (prev.val == end.val) {
                break;
            }
        }
        return prev;
    }

}
