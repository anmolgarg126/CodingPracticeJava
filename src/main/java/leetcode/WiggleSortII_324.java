package main.java.leetcode;

import java.util.Arrays;

public class WiggleSortII_324 {
    public static void main(String[] args) {
        var obj = new WiggleSortII_324();
        obj.testCase1();
    }

    private void testCase1() {
        int[] input1 = {1, 5, 1, 1, 6, 4};
        wiggleSort(input1);
        System.out.println(Arrays.toString(input1));
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

    }

    //TODO:: complete
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
