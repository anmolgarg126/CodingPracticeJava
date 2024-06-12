package main.java.leetcode;

import java.util.Arrays;

public class SortColors_75 {
    public static void main(String[] args) {
        var obj = new SortColors_75();
        int[] input1 = {0, 1, 0, 2, 1, 0, 1, 2, 1, 0, 1, 0};
        obj.sortColors(input1);
        System.out.println(Arrays.toString(input1));
    }

    private void sortColors(int[] nums) {
        int l = 0, m = 0, r = nums.length - 1;

        while (m <= r) {
            if (nums[m] == 0) {
                swap(nums, m, l);
                m++;
                l++;
            } else if (nums[m] == 1) {
                m++;
            } else {
                swap(nums, m, r);
                r--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
