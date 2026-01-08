package main.java.leetcode;

/*
Question: 2598. Smallest Missing Non-negative Integer After Operations
Link: https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/
 */
public class SmallestMissingNonNegativeIntegerAfterOperations_2598 {
    public static void main(String[] args) {
        var obj = new SmallestMissingNonNegativeIntegerAfterOperations_2598();
        System.out.println(obj.findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5));
        System.out.println(obj.findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 7));
    }

    public int findSmallestInteger(int[] nums, int value) {
        int[] rem = new int[value];
        for (int num : nums) {
            int r = ((num % value) + value) % value;
            rem[r]++;
        }
        int ans = 0;
        while (rem[ans % value] > 0) {
            rem[ans % value]--;
            ans++;
        }
        return ans;
    }
}
