package main.java.codingstudio.codingninja;


import main.java.common.ListNode;

/*
Question: Modular Node
Link:
 */
public class ModularNode {
    public static void main(String[] args) {

    }

    public static ListNode modularNode(int k, ListNode head) {
        // Write your code here.
        int i = 0;
        ListNode res = new ListNode(0);
        while (head != null) {
            i++;
            if (i % k == 0) {
                res = head;
            }
            head = head.next;
        }
        return res;
    }
}
