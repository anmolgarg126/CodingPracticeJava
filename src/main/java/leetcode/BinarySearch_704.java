package main.java.leetcode;

/*
Question: 704. Binary Search
Link: https://leetcode.com/problems/binary-search/
 */
public class BinarySearch_704 {
    public static void main(String[] args) {
        var obj = new BinarySearch_704();
        System.out.println(obj.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8));
        System.out.println(obj.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(obj.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
