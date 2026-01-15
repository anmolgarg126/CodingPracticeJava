package main.java.leetcode;

import java.util.Arrays;

/*
Question: 2943. Maximize Area of Square Hole in Grid
Link: https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/
 */
public class MaximizeAreaOfSquareHoleInGrid_2943 {
    public static void main(String[] args) {
        var obj = new MaximizeAreaOfSquareHoleInGrid_2943();
        System.out.println(obj.maximizeSquareHoleArea(2, 1, new int[]{2, 3}, new int[]{2, 4}));
        System.out.println(obj.maximizeSquareHoleArea(4, 40, new int[]{5,3,2,4}, new int[]{36,41,6,34,33}));
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxContinuousHBars = getMaxContinuousBars(hBars);
        int maxContinuousVBars = getMaxContinuousBars(vBars);
        return (int) Math.pow(Math.min(maxContinuousVBars - 1, maxContinuousHBars - 1) + 2, 2);
    }

    private static int getMaxContinuousBars(int[] bars) {
        Arrays.sort(bars);
        int maxContinuousBars = 1;
        int curr = 1;
        int prev = bars[0];
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == prev + 1) {
                curr++;
            } else {
                curr = 1;
            }
            maxContinuousBars = Math.max(maxContinuousBars, curr);
            prev = bars[i];
        }
        return maxContinuousBars;
    }
}
