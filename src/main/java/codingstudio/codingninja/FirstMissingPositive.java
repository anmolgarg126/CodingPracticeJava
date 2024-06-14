package main.java.codingstudio.codingninja;

import java.util.HashSet;
import java.util.Set;

/*
Question: First Missing Positive
Link: https://www.naukri.com/code360/problems/first-missing-positive_699946
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissing(new int[]{0, 1, 2, 3, 4}, 5));
        System.out.println(firstMissing(new int[]{3, 2, -6, 1, 0}, 5));
    }

    public static int firstMissing(int[] arr, int n) {
        // Write your code here.
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int i = 1;
        for (; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return i;
    }

}
