package main.java.leetcode;

import java.util.Arrays;

/*
Question: 1887. Reduction Operations to Make the Array Elements Equal
Link: https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 */
public class ReductionOperationsToMakeTheArrayElementsEqual_1887 {
    public static void main(String[] args) {
        var obj = new ReductionOperationsToMakeTheArrayElementsEqual_1887();
        System.out.println(obj.reductionOperations(new int[]{5, 1, 3}));
        System.out.println(obj.reductionOperations(new int[]{1, 1, 2, 2, 3}));
        System.out.println(obj.reductionOperations(new int[]{1, 1, 1}));
    }

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int up = 0; //keeps track of different values
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                up++;
            }
            res += up; // for every op, earlier ones also has be to updated
        }
        return res;
    }
}
