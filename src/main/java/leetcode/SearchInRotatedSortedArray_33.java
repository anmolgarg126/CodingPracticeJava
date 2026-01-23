package main.java.leetcode;

/*
Question: 33. Search in Rotated Sorted Array
Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray_33 {
    public static void main(String[] args) {
        var obj = new SearchInRotatedSortedArray_33();
        System.out.println(obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(obj.search(new int[]{1}, 0));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return target == nums[left] ? left : -1;
    }
}
