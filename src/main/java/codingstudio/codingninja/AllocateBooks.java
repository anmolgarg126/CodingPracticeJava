package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

/*
Question: Allocate Books
Link:
 */
public class AllocateBooks {
    public static void main(String[] args) {
        System.out.println(findPages(new ArrayList<>(Arrays.asList(12, 34, 67, 90)), 4, 2));
        System.out.println(findPages(new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24)), 5, 4));
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if (m > n) {
            return -1;
        }

        int start = 0, end = 0, ans = 0, mid;
        for (int i : arr) {
            start = Math.max(start, i);
            end += i;
        }

        while (start <= end) {
            mid = start + (end - start) / 2;
            int pages = 0, count = 1;
            for (int i = 0; i < n; i++) {
                pages += arr.get(i);
                if (pages > mid) {
                    count++;
                    pages = arr.get(i);
                }
            }
            if (count <= m) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
