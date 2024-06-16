package main.java.leetcode;

/*
Question: 330. Patching Array
Link: https://leetcode.com/problems/patching-array/description
 */
public class PatchingArray_330 {
    public static void main(String[] args) {
        var obj = new PatchingArray_330();
        System.out.println(obj.minPatches(new int[]{1, 3}, 6));
        System.out.println(obj.minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(obj.minPatches(new int[]{1, 2, 2}, 3));
    }

    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                result++;
            }
        }

        return result;
    }

}
