package main.java.leetcode;

import java.util.Arrays;

/*
Question: 1310. XOR Queries of a Subarray
Link: https://leetcode.com/problems/xor-queries-of-a-subarray
 */
public class XORQueriesOfASubarray_1310 {
    public static void main(String[] args) {
        var obj = new XORQueriesOfASubarray_1310();
        obj.testCase1();
        obj.testCase2();
    }

    private void testCase1() {
        int[] arr = new int[]{1, 3, 4, 8};
        int[][] queries = new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    private void testCase2() {
        int[] arr = new int[]{4, 8, 2, 10};
        int[][] queries = new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixSum = new int[arr.length];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp ^= arr[i];
            prefixSum[i] = temp;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int res = 0;
            if (queries[i][0] > 0) {
                res = prefixSum[queries[i][1]] ^ prefixSum[queries[i][0] - 1];
            } else {
                res = prefixSum[queries[i][1]];
            }
            result[i] = res;
        }
        return result;
    }
}
