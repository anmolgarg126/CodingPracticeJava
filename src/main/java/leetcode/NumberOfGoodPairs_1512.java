package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs_1512 {
    public static void main(String[] args) {
        var obj = new NumberOfGoodPairs_1512();
        System.out.println(obj.numIdenticalPairs2(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(obj.numIdenticalPairs2(new int[]{1, 1, 1, 1, 1}));
        System.out.println(obj.numIdenticalPairs2(new int[]{1, 2, 3}));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // since we have to find sum of 1,2,3, till freq-1
            int freq = entry.getValue() - 1;
            res += (freq * (freq + 1)) / 2;
        }
        return res;
    }

    public int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            res += map.get(num) - 1;
        }

        return res;
    }
}
