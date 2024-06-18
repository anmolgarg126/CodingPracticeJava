package main.java.leetcode;

/*
Question: 826. Most Profit Assigning Work
Link: https://leetcode.com/problems/most-profit-assigning-work
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        var obj = new MostProfitAssigningWork();
        obj.testCase1();
        obj.testCase2();
    }

    public void testCase1() {
        int[] workers = {4, 5, 6, 7};
        int[] profit = {10, 20, 30, 40, 50};
        int[] difficulty = {2, 4, 6, 8, 10};

        System.out.println(maxProfitAssignment(difficulty, profit, workers));
    }

    public void testCase2() {
        int[] workers = {40, 25, 25};
        int[] profit = {24, 66, 99};
        int[] difficulty = {85, 47, 57};

        System.out.println(maxProfitAssignment(difficulty, profit, workers));
    }

    static class Work {
        int profit;
        int difficulty;

        public Work(int profit, int difficulty) {
            this.profit = profit;
            this.difficulty = difficulty;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Queue<Work> difficulties = new PriorityQueue<>((a, b) -> a.difficulty - b.difficulty);
        Queue<Work> profits = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        Arrays.sort(worker);
        for (int i = 0; i < worker.length; i++) {
            difficulties.offer(new Work(profit[i], difficulty[i]));
        }

        int maxProfit = 0;

        for (int w : worker) {
            while (!difficulties.isEmpty() && difficulties.peek().difficulty <= w) {
                profits.offer(difficulties.poll());
            }
            maxProfit += profits.isEmpty() ? 0 : profits.peek().profit;
        }

        return maxProfit;
    }
}
