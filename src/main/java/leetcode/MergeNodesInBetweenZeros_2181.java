package main.java.leetcode;

import main.java.common.ListNode;

import static main.java.common.ListNode.generateList;
import static main.java.common.ListNode.printListNode;

/*
Question: 2181. Merge Nodes in Between Zeros
Link: https://leetcode.com/problems/merge-nodes-in-between-zeros
 */
public class MergeNodesInBetweenZeros_2181 {
    public static void main(String[] args) {
        var obj = new MergeNodesInBetweenZeros_2181();
        obj.testCase1();
    }

    private void testCase1() {
        // 0,3,1,0,4,5,2,0
        ListNode n1 = generateList(new int[]{0, 3, 1, 0, 4, 5, 2, 0});
        System.out.println(printListNode(mergeNodes(n1)));
    }

    public ListNode mergeNodes(ListNode head) {
        // Initialize a sentinel/dummy node with the first non-zero value.
        ListNode modify = head.next;
        ListNode nextSum = modify;

        while (nextSum != null) {
            int sum = 0;
            // Find the sum of all nodes until you encounter a 0.
            while (nextSum.val != 0) {
                sum += nextSum.val;
                nextSum = nextSum.next;
            }

            // Assign the sum to the current node's value.
            modify.val = sum;
            // Move nextSum to the first non-zero value of the next block.
            nextSum = nextSum.next;
            // Move modify also to this node.
            modify.next = nextSum;
            modify = modify.next;
        }
        return head.next;
    }
}
