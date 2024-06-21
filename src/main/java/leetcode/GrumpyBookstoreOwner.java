package main.java.leetcode;

/*
Question: 1052. Grumpy Bookstore Owner
Link: https://leetcode.com/problems/grumpy-bookstore-owner
 */
public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        var obj = new GrumpyBookstoreOwner();
        System.out.println(obj.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        System.out.println(obj.maxSatisfied(new int[]{1}, new int[]{0}, 1));
        System.out.println(obj.maxSatisfied(new int[]{3}, new int[]{1}, 1));
        System.out.println(obj.maxSatisfied(new int[]{2, 6, 6, 9}, new int[]{0, 0, 1, 1}, 1));
    }


    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int original = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                original += customers[i];
            }
        }

        int l = 0, r = 0, curr = 0, max = 0;
        while (r < customers.length) {
            if (grumpy[r] == 1) {
                curr += customers[r];
            }
            if (r - l + 1 == minutes) {
                max = Math.max(max, curr);
                if (grumpy[l] == 1) {
                    curr -= customers[l];
                }
                l++;
            }
            r++;
        }
        return max + original;
    }

}
