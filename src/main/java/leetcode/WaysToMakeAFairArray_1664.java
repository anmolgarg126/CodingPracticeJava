package main.java.leetcode;

/*
Question: 1664. Ways to Make a Fair Array
Link: https://leetcode.com/problems/ways-to-make-a-fair-array/
 */
public class WaysToMakeAFairArray_1664 {
    public static void main(String[] args) {
        var obj = new WaysToMakeAFairArray_1664();
        System.out.println(obj.waysToMakeFair(new int[]{2, 1, 6, 4}));
        System.out.println(obj.waysToMakeFair(new int[]{1,1,1}));
        System.out.println(obj.waysToMakeFair(new int[]{1,2,3}));
    }

    /*
    We can have 2 array right and left where 0th index will contain even sum and 1st index will contain odd sum;
    So basically we are calculating right and left prefix sum with odd and even indexes;
     */
    public int waysToMakeFair(int[] nums) {
        int[] right = new int[2];
        int[] left = new int[2];
        for (int i = 0; i < nums.length; i++) {
            right[i % 2] += nums[i];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            right[i % 2] -= nums[i];
            // even and odd indexes will shift once we remove any element
            if (left[0] + right[1] == left[1] + right[0]) {
                res++;
            }
            left[i % 2] += nums[i];
        }
        return res;
    }
}
