package main.java.leetcode;

import java.util.Stack;

/*
Question: 62. Maximum Width Ramp
Link: https://leetcode.com/problems/maximum-width-ramp/description
 */
public class MaximumWidthRamp_62 {
    public static void main(String[] args) {
        var obj = new MaximumWidthRamp_62();
        System.out.println(obj.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(obj.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                max = Math.max(max, i - stack.pop());
            }
        }
        return max;
    }
}
