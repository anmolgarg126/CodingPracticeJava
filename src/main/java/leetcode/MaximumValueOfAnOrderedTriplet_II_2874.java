package main.java.leetcode;

/*
Question: 2874. Maximum Value of an Ordered Triplet II
 */
public class MaximumValueOfAnOrderedTriplet_II_2874 {
    public static void main(String[] args) {
        var obj = new MaximumValueOfAnOrderedTriplet_II_2874();
        System.out.println(obj.maximumTripletValue_2(new int[]{12, 6, 1, 2, 7}));
        System.out.println(obj.maximumTripletValue_2(new int[]{1, 10, 3, 4, 19}));

    }

    // Approach 1: Greedy + Prefix Suffix Array
    public long maximumTripletValue_1(int[] nums) {
        // Intuition:
        /*
        Let the length of the array nums be n. According to the value formula (nums[i]−nums[j])×nums[k], it can be known
        that when j is fixed, the maximum value of the triplet is achieved when nums[i] and nums[k] respectively take
        the maximum values from [0,j) and [j+1,n). We use leftMax[j] and rightMax[j] to maintain the maximum value of
        the prefix [0,j) and the maximum value of the suffix [j+1,n), respectively, and enumerate j in order,
        calculate the value (leftMax[j]−nums[j])×rightMax[j], and return the maximum value (if all values are negative,
        return 0).
         */

        /*
        Complexity Analysis
        Let n be the length of the array nums.

        Time complexity: O(n).
        During the traversal of the array, the prefix and suffix arrays can be maintained, thus achieving a single traversal.

        Space complexity: O(n).
        Two arrays are needed to maintain the maximum and minimum values of the prefixes and suffixes.
         */


        int n = nums.length;
        int[] iMax = new int[n];
        int[] kMax = new int[n];

        for (int i = 1; i < n; i++) {
            iMax[i] = Math.max(iMax[i - 1], nums[i - 1]);
            kMax[n - 1 - i] = Math.max(kMax[n - i], nums[n - i]);
        }
//        System.out.println(Arrays.toString(iMax));
//        System.out.println(Arrays.toString(kMax));

        long res = 0;
        for (int j = 1; j < n - 1; j++) {
            res = Math.max(res, (long) (iMax[j] - nums[j]) * kMax[j]);
        }

        return res;
    }

    // Approach 2: Greedy
    public long maximumTripletValue_2(int[] nums) {
        /*
        Similar to approach 1, if we fix k, then the value of the triplet is maximized when nums[i]−nums[j] takes
        the maximum value. We can use imax to maintain the maximum value of nums[i], and dmax to maintain the maximum
        value of nums[i]−nums[j]. During the enumeration of k, update dmax and imax.
         */

        /*
        Complexity Analysis
        Let n be the length of the array nums.

        Time complexity: O(n).
        Similar to approach 1, in the process of a single traversal, the maximum and minimum values can be maintained.

        Space complexity: O(1).
        We only need two variables to maintain the maximum and minimum values.
         */

        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);

        }
        return res;
    }
}
