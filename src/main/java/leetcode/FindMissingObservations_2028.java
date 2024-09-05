package main.java.leetcode;

import java.util.Arrays;

/*
Question: 2028. Find Missing Observations
link: https://leetcode.com/problems/find-missing-observations
 */
public class FindMissingObservations_2028 {
    public static void main(String[] args) {
        var obj = new FindMissingObservations_2028();
        System.out.println(Arrays.toString(obj.missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
        System.out.println(Arrays.toString(obj.missingRolls(new int[]{1,5,6}, 3, 4)));
        System.out.println(Arrays.toString(obj.missingRolls(new int[]{1,2,3,4}, 6, 4)));
        System.out.println(Arrays.toString(obj.missingRolls(new int[]{4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5}, 4, 40)));
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int currentSum = 0;
        for (int i = 0; i < rolls.length; i++) {
            currentSum += rolls[i];
        }
        int expectedSum = mean * (n + rolls.length);

        int remainder = expectedSum - currentSum;

        if (remainder > (n * 6) || remainder < n) {
            return new int[]{};
        }
        int roll = remainder / n;
        int tempRemainder = remainder % n;

        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int curr = roll;
            if (tempRemainder > 0) {
                curr += 1;
                tempRemainder--;
            }
            result[i] = curr;
            remainder -= curr;
        }
        result[n - 1] = remainder;
        return result;
    }
}
