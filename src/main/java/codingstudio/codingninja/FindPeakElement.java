package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

/*
Question: Find Peak Element
Link: https://www.naukri.com/code360/problems/find-peak-element_9404534
 */
public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new ArrayList<>(Arrays.asList(1, 8, 1, 5, 3))));
        System.out.println(findPeakElement(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
    }

    public static int findPeakElement(ArrayList<Integer> arr) {
        // Write your code here.
        int start = 0, end = arr.size() - 1;


        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {

                end = mid;

            } else {
                start = mid + 1;
            }

        }
        return start;

    }
}
