package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Question: 2110. Number of Smooth Descent Periods of a Stock
Link: https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock
 */
public class NumberOfSmoothDescentPeriodsOfAStock_2110 {
    public static void main(String[] args) {
        var obj = new NumberOfSmoothDescentPeriodsOfAStock_2110();
        System.out.println(obj.getDescentPeriods(new int[]{3, 2, 1, 4}));
        System.out.println(obj.getDescentPeriods(new int[]{8, 6, 7, 7}));
        System.out.println(obj.getDescentPeriods(new int[]{1}));
    }

    public long getDescentPeriods(int[] prices) {
        long res = 1;
        long prev = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                prev++;
            } else {
                prev = 1;
            }
            res += prev;
        }
        return res;
    }
}
