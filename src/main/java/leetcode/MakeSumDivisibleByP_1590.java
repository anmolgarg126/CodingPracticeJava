package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Question: 1590. Make Sum Divisible by P
Link: https://leetcode.com/problems/make-sum-divisible-by-p/
 */
public class MakeSumDivisibleByP_1590 {
    public static void main(String[] args) {
        var obj = new MakeSumDivisibleByP_1590();
        System.out.println(obj.minSubarray(new int[]{3, 1, 4, 2}, 6));
        System.out.println(obj.minSubarray(new int[]{1, 2, 3}, 3));
        System.out.println(obj.minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));
    }

    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int remainder = (int)(total % p);
        if (remainder == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            curr = (curr + nums[i]) % p;
            int prefix = (curr - remainder + p) % p;// to avoid negatives
            if (map.containsKey(prefix)) {
                int i1 = map.get(prefix);
                min = Math.min(min, i - i1);
            }
            map.put(curr, i);
        }
        return min == nums.length ? -1 : min;
    }
}
