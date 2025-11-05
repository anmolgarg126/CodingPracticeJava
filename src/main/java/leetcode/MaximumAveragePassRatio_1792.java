package main.java.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Question: 1792. Maximum Average Pass Ratio
Link: https://leetcode.com/problems/maximum-average-pass-ratio/description
 */
public class MaximumAveragePassRatio_1792 {
    public static void main(String[] args) {
        var obj = new MaximumAveragePassRatio_1792();
        System.out.println(obj.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
        System.out.println(obj.maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Ratio> minHeap = new PriorityQueue<>(Comparator.comparingDouble((Ratio r) -> r.gain).reversed());
        for (int[] a : classes) {
            minHeap.add(new Ratio(a[0], a[1]));
        }
        while (extraStudents > 0 && !minHeap.isEmpty()) {
            Ratio curr = minHeap.poll();
            minHeap.add(new Ratio(curr.pass + 1, curr.total + 1));
            extraStudents--;
        }

        double sum = 0;
        double totalClasses = minHeap.size();
        while (!minHeap.isEmpty()) {
            Ratio curr = minHeap.poll();
            sum += curr.passRatio;
        }
        return sum / totalClasses;
    }

    static class Ratio {
        int pass;
        int total;
        double passRatio;
        double gain;

        public Ratio(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.passRatio = (double) pass / (double) (total);
            this.gain = (double) (pass + 1) / (total + 1) - (double) pass / total;
        }
    }
}
