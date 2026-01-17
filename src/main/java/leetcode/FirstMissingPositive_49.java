package main.java.leetcode;

/*
Question: 41. First Missing Positive
Link: https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive_49 {
    public static void main(String[] args) {
        var obj = new FirstMissingPositive_49();
        System.out.println(obj.firstMissingPositive(new int[]{1, 2, 3, 4}));
        System.out.println(obj.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(obj.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(obj.firstMissingPositive(new int[]{-5}));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for (int i : nums) {
            if (Math.abs(i) > n) {
                continue;
            }
            int idx = Math.abs(i) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
