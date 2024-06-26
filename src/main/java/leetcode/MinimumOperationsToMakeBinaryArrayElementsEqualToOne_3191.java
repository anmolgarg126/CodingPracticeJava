package main.java.leetcode;

/*
Question: 3191. Minimum Operations to Make Binary Array Elements Equal to One I
Link: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i
 */
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOne_3191 {

    public static void main(String[] args) {
        var obj = new MinimumOperationsToMakeBinaryArrayElementsEqualToOne_3191();
        System.out.println(obj.minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(obj.minOperations(new int[]{0, 1, 1, 1}));
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && i < n - 2) {
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] == 1 ? 0 : 1;
                nums[i + 2] = nums[i + 2] == 1 ? 0 : 1;
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }
        return count;
    }
}
