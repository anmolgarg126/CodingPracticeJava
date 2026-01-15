package main.java.leetcode;

/*
Question: 26. Remove Duplicates from Sorted Array
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        var obj = new RemoveDuplicatesFromSortedArray_26();
        System.out.println(obj.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(obj.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(obj.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
