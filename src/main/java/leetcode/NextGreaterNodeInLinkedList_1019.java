package main.java.leetcode;

import main.java.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Question: 1019. Next Greater Node In Linked List
Link: https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeInLinkedList_1019 {
    public static void main(String[] args) {
        var obj = new NextGreaterNodeInLinkedList_1019();
        System.out.println(Arrays.toString(obj.nextLargerNodes(ListNode.generateList(new int[]{2, 1, 5}))));
        System.out.println(Arrays.toString(obj.nextLargerNodes(ListNode.generateList(new int[]{2, 7, 4, 3, 5}))));
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        Stack<Integer> stack = new Stack<>();
        int n = list.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
