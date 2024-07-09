package main.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Question: 350. Intersection of Two Arrays II
Link: https://leetcode.com/problems/intersection-of-two-arrays-ii
 */
public class IntersectionOfTwoArraysII_350 {
    public static void main(String[] args) {
        var obj = new IntersectionOfTwoArraysII_350();
        System.out.println(Arrays.toString(obj.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(obj.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            m1.merge(nums1[i], 1, Integer::sum);
        }

        int[] arr = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            int freq = m1.getOrDefault(nums2[i], 0);
            if (freq > 0) {
                arr[index++] = nums2[i];
                m1.put(nums2[i], freq - 1);
            }
        }

        return Arrays.copyOfRange(arr, 0, index);
    }
}
