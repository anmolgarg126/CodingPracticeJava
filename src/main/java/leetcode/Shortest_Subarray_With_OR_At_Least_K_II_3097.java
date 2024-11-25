package main.java.leetcode;

/*
Question: 3097. Shortest Subarray With OR at Least K II
Link: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii
 */
public class Shortest_Subarray_With_OR_At_Least_K_II_3097 {
    public static void main(String[] args) {
        var obj = new Shortest_Subarray_With_OR_At_Least_K_II_3097();
//        System.out.println(obj.minimumSubarrayLength(new int[]{1, 2, 3}, 3));
//        System.out.println(obj.minimumSubarrayLength(new int[]{2, 1, 8}, 10));
//        System.out.println(obj.minimumSubarrayLength(new int[]{1, 2}, 0));
        System.out.println(obj.minimumSubarrayLength(new int[]{1, 2, 32, 21}, 55));
//        System.out.println(obj.minimumSubarrayLength(new int[]{5,1,32,86,2}, 117));
//        System.out.println(obj.minimumSubarrayLength(new int[]{2,1,6,32,86,56}, 123));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0;
        int curr = 0, res = Integer.MAX_VALUE;
        while (right < nums.length) {
            curr |= nums[right];

            if (nums[right] >= curr) {
                left = right;
            }

            if (curr >= k) {
                res = Math.min(res, right - left + 1);
                if (res == 1) {
                    break;
                }
//                int temp = curr;
//                while (left < right && temp >= k) {
//                    curr = temp;
//                    int c = ~nums[left];
//                    temp = temp & c;
//                    left++;
//                }
            }

            right++;
        }
        return res;

    }
}
