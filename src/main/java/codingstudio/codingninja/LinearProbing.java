package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Question:  Linear Probing
Link: https://www.naukri.com/code360/problems/linear-probing_982799
 */
public class LinearProbing {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(linearProbing(new ArrayList<>(Arrays.asList(5, 3, 2, 6, 4)))));
        System.out.println(Arrays.toString(linearProbing(new ArrayList<>(Arrays.asList(1, 5, 3, 7)))));
        System.out.println(Arrays.toString(linearProbing(new ArrayList<>(Arrays.asList(6, 7, 10)))));
        System.out.println(Arrays.toString(linearProbing(new ArrayList<>(Arrays.asList(4, 7, 8, 1, 2, 5)))));
    }

    public static int[] linearProbing(List<Integer> keys) {
        // Write your code here.
        int n = keys.size();
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i : keys) {
            int index = i % n;
            while (res[index] != -1) {
                index = (index + 1) % n;
            }
            res[index] = i;
        }
        return res;
    }

}
