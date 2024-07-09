package main.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/*
Question: 1823. Find the Winner of the Circular Game
Link: https://leetcode.com/problems/find-the-winner-of-the-circular-game
 */
public class FindTheWinnerOfTheCircularGame_1823 {
    public static void main(String[] args) {
        var obj = new FindTheWinnerOfTheCircularGame_1823();
        System.out.println(obj.findTheWinner(5, 2));
        System.out.println(obj.findTheWinner(6, 5));

        System.out.println(obj.findTheWinnerBetter(5, 2) + 1);
        System.out.println(obj.findTheWinnerBetter(6, 5) + 1);

        System.out.println(obj.findTheWinnerTopDown(5, 2));
        System.out.println(obj.findTheWinnerTopDown(6, 5));
    }

    public int findTheWinner(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                list.add(list.remove(0));
            }
            list.remove(0);
        }
        return list.get(0);
    }

    public int findTheWinnerBetter(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (findTheWinnerBetter(n - 1, k) + k) % n;
    }

    public int findTheWinnerTopDown(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + k) % i;
        }
        return res + 1;
    }


}
