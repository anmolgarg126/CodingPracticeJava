package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

/*
Question: First and Last Position of an Element In Sorted Array
Link: https://www.naukri.com/code360/problems/first-and-last-position-of-an-element-in-sorted-array_1082549
 */
public class FirstAndLastPositionOfAnElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstAndLastPosition(new ArrayList<>(Arrays.asList(0, 1, 1, 5)), 4, 1)));
        System.out.println(Arrays.toString(firstAndLastPosition(new ArrayList<>(Arrays.asList(1, 3, 3, 5)), 4, 2)));
        System.out.println(Arrays.toString(firstAndLastPosition(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 2, 2, 2, 2
        )), 8, 2)));
    }

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        return new int[]{smallestIndex(arr, n, k), largestIndex(arr, n, k)};
    }

    private static int smallestIndex(ArrayList<Integer> arr, int n, int k) {
        int l = 0, r = n - 1;
        int mid;
        int result = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int curr = arr.get(mid);

            if (curr == k) {
                result = mid;
                r = mid - 1;
            } else if (curr < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private static int largestIndex(ArrayList<Integer> arr, int n, int k) {
        int l = 0, r = n - 1;
        int mid;
        int result = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;

            int curr = arr.get(mid);

            if (curr == k) {
                result = mid;
                l = mid + 1;
            } else if (curr < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
