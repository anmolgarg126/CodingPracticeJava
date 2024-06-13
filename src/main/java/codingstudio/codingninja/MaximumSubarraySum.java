package main.java.codingstudio.codingninja;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{1, 2, 7, -4, 3, 2, -10, 9, 1}, 9));
        System.out.println(maxSubarraySum(new int[]{10, 20, -30, 40, -50, 60}, 6));
        System.out.println(maxSubarraySum(new int[]{18, -6, -6, -5, 7, 10, 16, -6, -2, 0}, 10));
    }

    public static long maxSubarraySum(int[] arr, int n) {
        // write your code here
        int r = 0;
        long sum = 0, res = 0;
        while (r < n) {
            sum += arr[r];
            res = Math.max(sum, res);
            sum = Math.max(0, sum);
            r++;
        }

        return res;
    }
}
