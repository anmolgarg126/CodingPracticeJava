package main.java.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Question: IPO
Link: https://leetcode.com/problems/ipo/description
 */
public class IPO_502 {
    public static void main(String[] args) {
        var obj = new IPO_502();
        obj.testCase1();
        obj.testCase2();
        obj.testCase3();
    }

    static class Project {
        int profit;
        int capital;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    private void testCase1() {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(findMaximizedCapital(2, 0, profits, capital));
    }

    private void testCase2() {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 2};
        System.out.println(findMaximizedCapital(3, 0, profits, capital));
    }

    private void testCase3() {
        int[] profits = {1, 2, 3};
        int[] capital = {1, 1, 2};
        System.out.println(findMaximizedCapital(1, 2, profits, capital));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Project> minCapital = new PriorityQueue<>(Comparator.comparing(a -> a.capital));
        Queue<Project> maxProfit = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        for (int i = 0; i < profits.length; i++) {
            minCapital.add(new Project(capital[i], profits[i]));
        }

        while (k-- > 0) {
            while (!minCapital.isEmpty() && minCapital.peek().capital <= w) {
                maxProfit.add(minCapital.poll());
            }
            if (maxProfit.isEmpty()) {
                return w;
            }
            w += maxProfit.poll().profit;
        }
        return w;
    }
}
