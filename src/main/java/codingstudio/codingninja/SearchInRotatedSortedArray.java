package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

/*
Question: Search In Rotated Sorted Array
Link: https://www.naukri.com/code360/problems/search-in-rotated-sorted-array_1082554
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new ArrayList<>(Arrays.asList(12, 15, 18, 2, 4)), 5, 2));
        System.out.println(search(new ArrayList<>(Arrays.asList(8, 9, 4, 5)), 4, 3));
        System.out.println(search(new ArrayList<>(Arrays.asList(2, 3, 5, 8)), 4, 3));
    }

    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int l = 0, r = n - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            int midVal = arr.get(m);

            if (midVal == k) {
                return m;
            } else {
                int leftVal = arr.get(l);
                if (midVal >= leftVal) {
                    if (leftVal <= k && midVal >= k) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    int rightVal = arr.get(r);
                    if (midVal <= k && rightVal >= k) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
            }
        }
        return -1;
    }
}
