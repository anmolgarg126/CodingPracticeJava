package main.java.leetcode;

import java.util.Arrays;

/*
Question: 16. 3Sum Closest
Link: https://leetcode.com/problems/3sum-closest
 */
public class ThreeSumClosest_16 {
    public static void main(String[] args) {
        var obj = new ThreeSumClosest_16();
        System.out.println(obj.threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 3));
        System.out.println(obj.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(obj.threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int currDiff = Math.abs(target - sum);
                if (currDiff < diff) {
                    res = sum;
                    diff = currDiff;
                }
                if (sum <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
