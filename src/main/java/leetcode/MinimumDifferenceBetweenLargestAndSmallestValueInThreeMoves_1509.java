package main.java.leetcode;

import java.util.Arrays;

/*
Question: 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
Link: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_1509 {
    public static void main(String[] args) {
        var obj = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_1509();
//        System.out.println(obj.minimumDifference(new int[]{5, 3, 2, 4}));
        System.out.println(obj.minimumDifference(new int[]{1, 5, 0, 10, 14}));
//        System.out.println(obj.minimumDifference(new int[]{3, 100, 20}));
    }

    public int minimumDifference(int[] nums) {
        if (nums == null || nums.length <= 4) return 0;
        Arrays.sort(nums);

        int n = nums.length;
        int ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, nums[n - i - 1] - nums[i]);
        }
        return ans;
    }
}
