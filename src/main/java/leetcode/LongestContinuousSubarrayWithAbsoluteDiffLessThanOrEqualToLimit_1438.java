package main.java.leetcode;

import java.util.LinkedList;

/*
Question: 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
Link: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_1438 {
    public static void main(String[] args) {
        var obj = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_1438();
        System.out.println(obj.longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(obj.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(obj.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
        System.out.println(obj.longestSubarray(new int[]{24, 12, 71, 33, 5, 87, 10, 11, 3, 58, 2, 97, 97, 36, 32, 35, 15, 80, 24, 45, 38, 9, 22, 21, 33, 68, 22, 85, 35, 83, 92, 38, 59, 90, 42, 64, 61, 15, 4, 40, 50, 44, 54, 25, 34, 14, 33, 94, 66, 27, 78, 56, 3, 29, 3, 51, 19, 5, 93, 21, 58, 91, 65, 87, 55, 70, 29, 81, 89, 67, 58, 29, 68, 84, 4, 51, 87, 74, 42, 85, 81, 55, 8, 95, 39}, 87));

    }

    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            while (!increase.isEmpty() && n < increase.getLast()) {
                increase.removeLast();
            }
            increase.add(n);

            while (!decrease.isEmpty() && n > decrease.getLast()) {
                decrease.removeLast();
            }

            decrease.add(n);

            while (decrease.getFirst() - increase.getFirst() > limit) {
                if (nums[left] == decrease.getFirst()) {
                    decrease.removeFirst();
                }
                if (nums[left] == increase.getFirst()) {
                    increase.removeFirst();
                }
                left++;
            }

            int size = i - left + 1;
            max = Math.max(max, size);
        }

        return max;
    }
}

