package main.java.leetcode;

import java.util.Arrays;

/*
Question: 1552. Magnetic Force Between Two Balls
Link: https://leetcode.com/problems/magnetic-force-between-two-balls
 */

// TODO:: not complete
public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        var obj = new MagneticForceBetweenTwoBalls();
        System.out.println(obj.maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(obj.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 0, r = position.length - 1;
        int curr = position[r] - position[l];
        if (m == 2) {
            return curr;
        }
        int res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;

        }
        return res;
    }
}
