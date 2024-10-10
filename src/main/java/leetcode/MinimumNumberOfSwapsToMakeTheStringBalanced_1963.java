package main.java.leetcode;

/*
Question: 1963. Minimum Number of Swaps to Make the String Balanced
Link: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced_1963 {
    public static void main(String[] args) {
        var obj = new MinimumNumberOfSwapsToMakeTheStringBalanced_1963();
        System.out.println(obj.minSwaps("][]["));
        System.out.println(obj.minSwaps("]]][[["));
        System.out.println(obj.minSwaps("[]"));
    }

    /*
    Here, we are keeping track of invalid closing brackets, max count to determine the number of swaps.
    In one swap, 2 brackets are resolved, so res = (max+1)/2
     */
    public int minSwaps(String s) {
        int closingBracketCount = 0;
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                closingBracketCount--;
            } else {
                closingBracketCount++;
            }

            maxCount = Math.max(maxCount, closingBracketCount);
        }

        return (maxCount + 1) / 2;
    }
}
