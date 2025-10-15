package main.java.leetcode;

import java.util.Arrays;

/*
Question: 2300. Successful Pairs of Spells and Potions
Link: https://leetcode.com/problems/successful-pairs-of-spells-and-potions
 */
public class SuccessfulPairsOfSpellsAndPotions_2300 {
    public static void main(String[] args) {
        var obj = new SuccessfulPairsOfSpellsAndPotions_2300();
        System.out.println(Arrays.toString(obj.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(obj.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int index = n; // left most index that we need to consider
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) spells[i] * (long) potions[mid] >= success) {
                    r = mid - 1;
                    index = mid;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = n - index;
        }
        return res;
    }
}
