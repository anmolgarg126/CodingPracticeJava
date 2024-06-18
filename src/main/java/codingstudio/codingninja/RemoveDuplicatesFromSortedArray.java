package main.java.codingstudio.codingninja;

/*
Question: Remove Duplicates from Sorted Array
Link: https://www.naukri.com/code360/problems/remove-duplicates-from-sorted-array_1102307
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        int res = removeDuplicates(nums, nums.length);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    private static void testCase2() {
        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5, 5};
        int res = removeDuplicates(nums, nums.length);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int removeDuplicates(int[] arr, int n) {
        // Write your code here.
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[j]) {
                arr[++j] = arr[i];
            }
        }
        // return j+1 as it is 0-based index, so length = j+1
        return j + 1;
    }
}
