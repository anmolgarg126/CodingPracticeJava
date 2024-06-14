package main.java.codingstudio.codingninja;

import main.java.common.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new ArrayList<>(Arrays.asList(2, 7, 11, 13)), 9, 4));
        System.out.println(twoSum(new ArrayList<>(Arrays.asList(1, -1, -1, 2, 2)), 1, 5));
    }

    static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Pair<Integer, Integer>> res = new ArrayList<>();

        for (int i : arr) {
            int t = target - i;
            if (map.containsKey(t) && map.get(t) > 0) {
                res.add(new Pair<>(i, t));
                map.merge(t, -1, Integer::sum);
            } else {
                map.merge(i, 1, Integer::sum);
            }
        }
        if (res.isEmpty()) {
            res.add(new Pair<>(-1, -1));
        }

        return res;
    }
}
