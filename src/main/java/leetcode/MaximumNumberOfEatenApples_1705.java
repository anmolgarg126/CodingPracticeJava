package main.java.leetcode;

import java.util.PriorityQueue;

/*
Question: 1705. Maximum Number of Eaten Apples
Link: https://leetcode.com/problems/maximum-number-of-eaten-apples/
 */
public class MaximumNumberOfEatenApples_1705 {
    public static void main(String[] args) {
        var obj = new MaximumNumberOfEatenApples_1705();
        System.out.println(obj.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println(obj.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
        System.out.println(obj.eatenApples(new int[]{2, 1, 1, 4, 5}, new int[]{10, 10, 6, 4, 2}));
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int res = 0;
        for (int i = 0; i < apples.length || !pq.isEmpty(); i++) {
            if (i < apples.length) {
                pq.offer(new int[]{apples[i], days[i] + i});
            }
            while (!pq.isEmpty() && (pq.peek()[1] <= i || pq.peek()[0] <= 0)) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res++;
                pq.peek()[0]--;
            }
        }
        return res;
    }

}
