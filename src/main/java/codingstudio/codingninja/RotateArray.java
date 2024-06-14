package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Question: Rotate array
Link: https://www.naukri.com/code360/problems/rotate-array_1230543
 */
public class RotateArray {
    public static void main(String[] args) {
        //1,2,3,4,5 -> original arr
        // 3,2,1,5,4 -> rev from 0 to k-1, and k to len-1, here k=3
        // 4,5,1,2,3 -> rev entire arr
        System.out.println(rotateArray(new ArrayList<>(Arrays.asList(7, 5, 2, 11, 2, 43, 1, 1)), 2));
    }


    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        // Write your code here.
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.size() - 1);
        reverse(arr, 0, arr.size() - 1);
        return arr;
    }

    private static void reverse(ArrayList<Integer> arr, int l, int r) {
        while (l < r) {
            Collections.swap(arr, l, r);
            l++;
            r--;
        }
    }


}
