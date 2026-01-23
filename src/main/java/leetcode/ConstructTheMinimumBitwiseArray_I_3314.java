package main.java.leetcode;

import java.util.Arrays;
import java.util.List;

/*
Question: 3314. Construct the Minimum Bitwise Array I
Link: https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/
 */

/*
Question: 3315. Construct the Minimum Bitwise Array II
Link: https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/
 */
public class ConstructTheMinimumBitwiseArray_I_3314 {
    public static void main(String[] args) {
        var obj = new ConstructTheMinimumBitwiseArray_I_3314();
        System.out.println(Arrays.toString(obj.minBitwiseArray(List.of(2, 3, 5, 7))));
        System.out.println(Arrays.toString(obj.minBitwiseArray(List.of(11, 13, 31))));
    }

    /*
    Adding 1 to a number, flips all trailing 1s to 0 and turns the first 0 bit (from least significant to most significant) into 1.
    Therefore, ans | (ans + 1) results in a number where all bits below that first 0 are 1, and that 0 becomes 1.

    To reverse this process for a given x, we look at x in binary from right to left.
    Any 1 bit that appears before the first 0 bit could have been flipped to 0 in ans to produce x.

    To get the smallest valid ans, we flip the lowest such 1 bit.
    This is done by iterating over the trailing 1s of x and subtracting the corresponding power of two.

    If x has no 1 before its first 0 (e.g., x = 2), no valid ans exists and we return -1.
     */
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int res = -1;
            int d = 1;
            while ((x & d) != 0) {
                res = x - d;
                d = d << 1;
            }
            result[i] = res;
        }
        return result;
    }
}
