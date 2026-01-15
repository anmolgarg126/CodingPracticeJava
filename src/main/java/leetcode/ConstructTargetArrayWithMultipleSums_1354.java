package main.java.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Question: 1354. Construct Target Array With Multiple Sums
link: https://leetcode.com/problems/construct-target-array-with-multiple-sums/
 */
public class ConstructTargetArrayWithMultipleSums_1354 {
    public static void main(String[] args) {
        var obj = new ConstructTargetArrayWithMultipleSums_1354();
        System.out.println(obj.isPossible(new int[]{9, 3, 5}));
        System.out.println(obj.isPossible(new int[]{1, 1, 1, 2}));
        System.out.println(obj.isPossible(new int[]{8, 5}));
        System.out.println(obj.isPossible(new int[]{1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 294967297}));
    }

    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i : target) {
            sum += i;
            queue.offer((long) i);
        }

        while (queue.peek() != 1) {
            long curr = queue.poll();
            if (sum - curr == 1) {
                return true;
            }
            long x = curr % (sum - curr);
            if (x == 0 || x == curr) {
                return false;
            }
            sum = sum - curr + x;
            queue.offer(x);
        }
        return true;
    }
}
