package main.java.codingstudio.codingninja;

import main.java.common.LinkedListNode;

/*
Question: Reverse Linked List
Link: https://www.naukri.com/code360/problems/reverse-the-singly-linked-list_799897
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        testCase1();
    }

    private static void testCase1() {
        // 1 2 3 4 5 6 -1
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> temp = head;
        temp.next = new LinkedListNode<>(2);
        temp.next.next = new LinkedListNode<>(3);
        temp.next.next.next = new LinkedListNode<>(4);
        temp.next.next.next.next = new LinkedListNode<>(5);
        temp.next.next.next.next.next = new LinkedListNode<>(6);
        temp.next.next.next.next.next.next = new LinkedListNode<>(-1);

        LinkedListNode<Integer> x = reverseLinkedList(head);
        System.out.println(x.print(x));

    }

    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {
        // Write your code here!
        LinkedListNode<Integer> cur = head;
        LinkedListNode<Integer> pre = null;
        while (cur != null) {
            LinkedListNode<Integer> temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
