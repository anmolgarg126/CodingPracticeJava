package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountCustomersWhoDidNotGetAComputer {
    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 2, 1, 1, 3, 2, 3, 4));
        System.out.println(countCustomers(list, 2));
    }

    private static void testCase2() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 2, 3));
        System.out.println(countCustomers(list, 1));
    }

    public static int countCustomers(ArrayList<Integer> arr, int k) {
        //    Write your code here
        Map<Integer, Boolean> map = new HashMap<>();
        int res = 0;

        for (int i : arr) {
            if (map.containsKey(i)) {
                if (map.get(i)) {
                    k++;
                }
                map.remove(i);
            } else {
                if (k == 0) {
                    res++;
                    map.put(i, false);
                } else {
                    k--;
                    map.put(i, true);
                }

            }
        }
        return res;
    }
}
