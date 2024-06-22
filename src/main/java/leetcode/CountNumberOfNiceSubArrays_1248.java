package main.java.leetcode;

/*
Question: 1248. Count Number of Nice Subarrays
Link: https://leetcode.com/problems/count-number-of-nice-subarrays
 */
public class CountNumberOfNiceSubArrays_1248 {
    public static void main(String[] args) {
        var obj = new CountNumberOfNiceSubArrays_1248();
        System.out.println(obj.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
        System.out.println(obj.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(obj.numberOfSubarrays(new int[]{2, 4, 6}, 1));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;
    }
}
