package main.java.leetcode;

/*
Question: 80. Remove Duplicates from Sorted Array II
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArray_II_80 {
    public static void main(String[] args) {
        var obj = new RemoveDuplicatesFromSortedArray_II_80();
        System.out.println(obj.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(obj.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        System.out.println(obj.removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 3}));
    }


    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
