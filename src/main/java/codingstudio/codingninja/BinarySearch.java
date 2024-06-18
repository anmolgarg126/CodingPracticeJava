package main.java.codingstudio.codingninja;

/*
Question: Binary Search
Link: https://www.naukri.com/code360/problems/binary-search_972
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(search(new int[]{1, 3, 7, 9, 11, 12, 45}, 3));
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7}, 9));
    }

    public static int search(int[] nums, int target) {
        // Write your code here.
        int l = 0, r = nums.length - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
