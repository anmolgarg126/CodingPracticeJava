package main.java.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Question: 1046. Last Stone Weight
Link: https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight_1046 {
    public static void main(String[] args) {
        var obj = new LastStoneWeight_1046();
        System.out.println(obj.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            queue.offer(a - b);
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
