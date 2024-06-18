package main.java.codingstudio.codingninja;

import java.util.HashMap;
import java.util.Map;

/*
Question: Longest Subarray With Sum K
Link: https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_5713505
 */
public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        System.out.println(getLongestSubarray(new int[]{2, 3, 5}, 5));
        System.out.println(getLongestSubarray(new int[]{-50, 0, 52}, 2));
        System.out.println(getLongestSubarray(new int[]{1, 1, 1}, 4));
        System.out.println(getLongestSubarray(new int[]{-1, 1, 1}, 1));
        System.out.println(getLongestSubarray(new int[]{1, 2, 4, 2, -3, 2}, 4));
        System.out.println(getLongestSubarray(new int[]{1, 2, 4, 2, -3, 2}, 4));
        System.out.println(getLongestSubarray(new int[]{1, 1, 1}, 1));
        System.out.println(getLongestSubarray(new int[]{-1,0,1,1,-1,-1,0}, 0));
    }

    public static int getLongestSubarray(int[] nums, int k) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            }
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return max;
    }
}
