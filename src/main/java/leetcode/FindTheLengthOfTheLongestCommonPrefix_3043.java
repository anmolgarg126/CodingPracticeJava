package main.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Question: 3043. Find the Length of the Longest Common Prefix
Link: https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix
 */
public class FindTheLengthOfTheLongestCommonPrefix_3043 {
    public static void main(String[] args) {
        var obj = new FindTheLengthOfTheLongestCommonPrefix_3043();
        System.out.println(obj.longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000}));
        System.out.println(obj.longestCommonPrefix(new int[]{1, 2, 3}, new int[]{4, 4, 4}));
    }


    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            String temp = String.valueOf(arr1[i]);
            for (int j = 0; j < temp.length(); j++) {
                set.add(Integer.parseInt(temp.substring(0, j + 1)));
            }
        }

        int max = 0;
        for (int i = 0; i < arr2.length; i++) {
            String temp = String.valueOf(arr2[i]);
            for (int j = 0; j < temp.length(); j++) {
                if (set.contains(Integer.parseInt(temp.substring(0, j + 1)))) {
                    max = Math.max(max, j + 1);
                }
            }
        }
        return max;
    }
}
