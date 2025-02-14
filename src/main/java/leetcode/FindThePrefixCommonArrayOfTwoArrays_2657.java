package main.java.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Question: 2657. Find the Prefix Common Array of Two Arrays
Link: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
 */
public class FindThePrefixCommonArrayOfTwoArrays_2657 {
    public static void main(String[] args) {
        var obj = new FindThePrefixCommonArrayOfTwoArrays_2657();
        obj.testCase1();
        obj.testCase2();
    }

    private void testCase1() {
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }

    private void testCase2() {
        int[] A = {2, 3, 1};
        int[] B = {3, 1, 2};
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> count = new HashMap<>();

        int[] result = new int[A.length];

        int curr = 0;
        for (int i = 0; i < A.length; i++) {
            count.merge(A[i], 1, Integer::sum);
            count.merge(B[i], 1, Integer::sum);


            int a = count.getOrDefault(A[i], 0);
            int b = count.getOrDefault(B[i], 0);
            if (A[i] == B[i]) {
                curr += a / 2;
            } else {
                curr = curr + (a / 2) + (b / 2);
            }
            result[i] = curr;
        }

        return result;
    }
}
