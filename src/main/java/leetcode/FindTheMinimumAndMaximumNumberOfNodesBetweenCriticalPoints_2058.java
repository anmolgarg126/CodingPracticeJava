package main.java.leetcode;

import main.java.common.ListNode;

import java.util.Arrays;

import static main.java.common.ListNode.generateList;

/*
Question: 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

 */
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints_2058 {
    public static void main(String[] args) {
        var obj = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints_2058();
        obj.testCase1();
        obj.testCase2();
        obj.testCase3();
    }

    private void testCase1() {
        //5,3,1,2,5,1,2
        ListNode n1 = generateList(new int[]{5, 3, 1, 2, 5, 1, 2});
//        System.out.println(printListNode(n1));
        System.out.println((Arrays.toString(nodesBetweenCriticalPoints(n1))));
    }

    private void testCase2() {
        //1,3,2,2,3,2,2,2,7
        ListNode n1 = generateList(new int[]{1, 3, 2, 2, 3, 2, 2, 2, 7});
//        System.out.println(printListNode(n1));
        System.out.println((Arrays.toString(nodesBetweenCriticalPoints(n1))));
    }

    private void testCase3() {
        //3,1
        ListNode n1 = generateList(new int[]{3, 1});
//        System.out.println(printListNode(n1));
        System.out.println((Arrays.toString(nodesBetweenCriticalPoints(n1))));
    }


    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int max = -1, min = -1, currMin = -1, currMax = -1;

        ListNode prev = head;
        ListNode curr = prev.next;
        while (curr != null && curr.next != null) {
            if ((curr.next.val > curr.val && prev.val > curr.val) || (curr.next.val < curr.val && prev.val < curr.val)) {
                max = Math.max(max, currMax);
                if (currMax == -1) {
                    currMax = 0;
                }

                if (currMin != -1) {
                    if (min == -1) {
                        min = currMin;
                    } else {
                        min = Math.min(min, currMin);
                    }
                }
                currMin = 0;
            }
            if (currMax != -1) {
                currMax++;
            }
            if (currMin != -1) {
                currMin++;
            }

            prev = curr;
            curr = curr.next;
        }

        return new int[]{min, max};
    }
}
