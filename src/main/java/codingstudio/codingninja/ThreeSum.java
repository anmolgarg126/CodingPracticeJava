package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

/*
Question: 3Sum
Link: https://www.naukri.com/code360/problems/triplets-with-given-sum_893028
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(findTriplets(new int[]{10, 5, 5, 5, 2}, 5, 12));
        System.out.println(findTriplets(new int[]{1, 2, 3, 1, 2, 3}, 6, 6));
        System.out.println(findTriplets(new int[]{1, 2, 3, 4}, 4, 11));
        System.out.println(findTriplets(new int[]{1, 1, 2, 2, 1, 1}, 6, 4));
    }

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K) {

        // Write your code here.
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == K) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    result.add(list);

                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                } else if (sum < K) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
