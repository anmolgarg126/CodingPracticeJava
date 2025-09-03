package main.java.leetcode;


import main.java.common.LinkedListNode;

/*
Question: 1290. Convert Binary Number in a Linked List to Integer
Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
 */
public class Convert_Binary_Number_In_Linked_List_To_Integer_1290 {
    public static void main(String[] args) {
        var obj = new Convert_Binary_Number_In_Linked_List_To_Integer_1290();
        obj.testCase1();
        obj.testCase2();
    }

    private void testCase1() {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(0);
        head.next.next = new LinkedListNode<>(1);
        System.out.println(getDecimalValue(head));
    }

    private void testCase2() {
        LinkedListNode<Integer> head = new LinkedListNode<>(0);
        System.out.println(getDecimalValue(head));
    }

    public int getDecimalValue(LinkedListNode<Integer> head) {
        int res = head.data;
        while (head.next != null) {
            res = res << 1 | head.next.data;
            head = head.next;
        }
        return res;
    }
}
