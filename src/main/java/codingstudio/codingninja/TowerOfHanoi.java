package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

/*
Question: Tower of Hanoi
Link:
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println(towerOfHanoi(1));
        System.out.println(towerOfHanoi(2));
        System.out.println(towerOfHanoi(3));
    }

    // Recursive function to solve Tower of Hanoi and record all moves

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        //    Write your code here.
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        toh(n, 1, 3, 2, res);
        return res;
    }

    private static void toh(int n, int from, int to, int aux, ArrayList<ArrayList<Integer>> res) {
        if (n == 0) {
            return;
        }
        toh(n - 1, from, aux, to, res);
        res.add(new ArrayList<>(Arrays.asList(from, to)));
        toh(n - 1, aux, to, from, res);
    }
}
