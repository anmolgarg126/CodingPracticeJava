package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Question: 523. Continuous Subarray Sum
Link: https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinuousSubarraySum_523 {
    public static void main(String[] args) {
        var obj = new ContinuousSubarraySum_523();
//        System.out.println(obj.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
//        System.out.println(obj.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(obj.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int r = prefixSum % k;
            if (!map.containsKey(r)) {
                map.put(r, i);
            } else if (i - map.get(r) > 1) {
                return true;
            }
        }
        return false;
    }
}
