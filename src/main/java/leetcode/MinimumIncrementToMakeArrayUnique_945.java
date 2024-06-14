package main.java.leetcode;

import java.util.Arrays;

/*
Question: 945. Minimum Increment to Make Array Unique
Link: https://leetcode.com/problems/minimum-increment-to-make-array-unique/description
 */

public class MinimumIncrementToMakeArrayUnique_945 {
    public static void main(String[] args) {
        var obj = new MinimumIncrementToMakeArrayUnique_945();
        System.out.println(obj.minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(obj.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            if (prev >= nums[i]) {
                res += prev - nums[i] + 1;
                nums[i] = prev + 1;
            }
        }
        return res;
    }
}
