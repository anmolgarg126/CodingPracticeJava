package main.java.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Question: 56. Merge Intervals
Link: https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals_56 {
    public static void main(String[] args) {
        var obj = new MergeIntervals_56();
        System.out.println(Arrays.deepToString(obj.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(obj.merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(obj.merge(new int[][]{{1, 4}, {2, 3}})));
        System.out.println(Arrays.deepToString(obj.merge(new int[][]{{4, 7}, {1, 4}})));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            res.add(new int[]{start, end});
            i = j - 1;
        }
        return res.toArray(new int[res.size()][]);
    }
}

