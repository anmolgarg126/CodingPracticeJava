package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSumSubarrayOfGivenSize {
    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 4, 2, 5, 6, 3, 8, 1));
        System.out.println(minSubarraySum(list, list.size(), 3));
    }

    private static void testCase2() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-21, 15, 14, 22, -4, 28, 24, -4, 14, -12, 3, -7, 22, -26, -28, 1, -11, 6, 6));
        System.out.println(minSubarraySum(list, list.size(), 9));
    }

    public static int minSubarraySum(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int l = 0, r = 0, sum = 0, res = Integer.MAX_VALUE;

        while (r < n) {
            sum += arr.get(r);

            if (r - l + 1 == k) {
                res = Math.min(sum, res);
                sum -= arr.get(l);
                l++;
            }
            r++;
        }
        return res;
    }
}
