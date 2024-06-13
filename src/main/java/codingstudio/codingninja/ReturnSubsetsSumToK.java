package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnSubsetsSumToK {


    public static void main(String[] args) {
        System.out.println(findSubsetsThatSumToK(new ArrayList<>(Arrays.asList(2, 4, 6)), 3, 6));
        System.out.println(findSubsetsThatSumToK(new ArrayList<>(Arrays.asList(5, -1, 8, 2, 7, 0)), 6, 7));
        System.out.println(findSubsetsThatSumToK(new ArrayList<>(Arrays.asList(5, -2, 0, -5, 2)), 5, 0));
    }

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(arr, new ArrayList<>(), res, n, k, 0, 0);
        return res;
    }

    private static void dfs(ArrayList<Integer> arr, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res, int n, int k, int sum, int index) {
        if (index == n) {
            // empty subset not required
            if (k == sum && !curr.isEmpty()) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        // include current
        curr.add(arr.get(index));
        dfs(arr, curr, res, n, k, sum + arr.get(index), index + 1);

        // remove curr
        curr.remove(curr.size() - 1);
        dfs(arr, curr, res, n, k, sum, index + 1);
    }
}
