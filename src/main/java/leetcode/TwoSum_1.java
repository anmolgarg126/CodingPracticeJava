package main.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Question: 1. Two Sum
Link: https://leetcode.com/problems/two-sum/
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        var obj = new TwoSum_1();
        System.out.println(Arrays.toString(obj.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(obj.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(obj.twoSum(new int[]{3,3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = target - nums[i];
            int otherIndex = map.getOrDefault(key, -1);
            if (otherIndex != -1) {
                return new int[]{otherIndex, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
