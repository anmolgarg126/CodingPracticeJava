package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Question: Sum Of Infinite Array
Link: https://www.naukri.com/code360/problems/sum-of-infinite-array_873335
 */
public class SumOfInfiniteArray {
    public static void main(String[] args) {
//        testcase1();
//        testcase2();
        testcase3();
    }

    private static void testcase1() {
        int[] arr = {1, 2, 3};
        List<List<Long>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1L, 3L));
        queries.add(Arrays.asList(1L, 5L));
        System.out.println(sumInRanges(arr, arr.length, queries, queries.size()));

    }

    private static void testcase2() {
        int[] arr = {5, 2, 6, 9};
        List<List<Long>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1L, 5L));
        queries.add(Arrays.asList(10L, 13L));
        queries.add(Arrays.asList(7L, 11L));
        System.out.println(sumInRanges(arr, arr.length, queries, queries.size()));
    }

    private static void testcase3() {
        int[] arr = {11, 11};
        List<List<Long>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1L, 2L));
        queries.add(Arrays.asList(1L, 3L));
        queries.add(Arrays.asList(2L, 3L));
        queries.add(Arrays.asList(2L, 4L));
        queries.add(Arrays.asList(1L, 10L));
        System.out.println(sumInRanges(arr, arr.length, queries, queries.size()));
    }

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {
        // Write your code here!
        int mod = 1000000007;
        int arrSum = 0;
        for (int j : arr) {
            arrSum = (arrSum % mod) + j;
        }


        List<Integer> result = new ArrayList<>(queries.size());
        for (List<Long> query : queries) {
            long start = (query.get(0) - 1) % n;
            long end = (query.get(1)) % n;
            long length = (query.get(1) - query.get(0) + 1) % mod;

            long res = (length / n) * arrSum;
            res = res % mod;

            for (int i = 0; i < start; i++) {
                res += arr[i];
            }
            for (int i = 0; i < end; i++) {
                res += arr[i];
            }

            result.add((int) res % mod);
        }
        return result;
    }

}
