package main.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Question: 1695. Maximum Erasure Value
Link: https://leetcode.com/problems/maximum-erasure-value
 */
public class MaximumErasureValue_1695 {
    public static void main(String[] args) {
        var obj = new MaximumErasureValue_1695();
        System.out.println(obj.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(obj.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
        System.out.println(obj.maximumUniqueSubarray(new int[]{187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434}));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 0, max = 0, curr = 0;

        Set<Integer> set = new HashSet<>();
        while (r < nums.length) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                curr -= nums[l];
                l++;
            }

            set.add(nums[r]);
            curr += nums[r];
            max = Math.max(max, curr);
            r++;
        }

        return max;
    }
}
