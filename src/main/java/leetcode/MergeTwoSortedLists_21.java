package main.java.leetcode;

import main.java.common.ListNode;

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        var obj = new MergeTwoSortedLists_21();
        obj.executeTestCase1();

    }

    private void executeTestCase1() {
        //1,2,4
        ListNode l1 = new ListNode(1);
        ListNode t1 = l1;
        t1.next = new ListNode(2);
        t1.next.next = new ListNode(4);

        //1,3,4
        ListNode l2 = new ListNode(1);//
        ListNode t2 = l2;
        t2.next = new ListNode(3);
        t2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode.print(listNode));
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) {
            return list1;
        }
        if (list1 == null) {
            return list2;
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return head.next;
    }


}
