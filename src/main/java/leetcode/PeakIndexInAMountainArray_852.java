package main.java.leetcode;

/*
Question: 852. Peak Index in a Mountain Array
Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInAMountainArray_852 {
    public static void main(String[] args) {
        var obj = new PeakIndexInAMountainArray_852();
        System.out.println(obj.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(obj.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(obj.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
