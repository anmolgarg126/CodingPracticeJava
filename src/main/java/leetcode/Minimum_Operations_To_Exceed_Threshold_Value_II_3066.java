package main.java.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Question: 3066. Minimum Operations to Exceed Threshold Value II
Link: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
 */
public class Minimum_Operations_To_Exceed_Threshold_Value_II_3066 {
    public static void main(String[] args) {
        var obj = new Minimum_Operations_To_Exceed_Threshold_Value_II_3066();
        System.out.println(obj.minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(obj.minOperations(new int[]{1, 1, 2, 4, 9}, 20));
        System.out.println(obj.minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000));
    }

    public int minOperations(int[] nums, int k) {
        Queue<Long> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer((long) num);
        }
        int count = 0;

        while (queue.size() > 1 && queue.peek() < k) {
            long poll1 = queue.poll();
            long poll2 = queue.poll();
            long res = performOperations(poll1, poll2);
            queue.offer(res);
            count++;
        }
        return count;
    }

    private long performOperations(long a, long b) {
        return (a * 2) + b;
    }
}
