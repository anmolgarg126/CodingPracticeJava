package main.java.leetcode;

import java.util.List;

/*
Question: 3350. Adjacent Increasing Subarrays Detection II
Link: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/description
 */
public class AdjacentIncreasingSubarraysDetection2_3350 {
    public static void main(String[] args) {
        var obj = new AdjacentIncreasingSubarraysDetection2_3350();
        System.out.println(obj.maxIncreasingSubarrays(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)));
        System.out.println(obj.maxIncreasingSubarrays(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)));
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int cnt = 1;
        int precnt = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cnt++;
            } else {
                precnt = cnt;
                cnt = 1;
            }
            ans = Math.max(ans, Math.min(precnt, cnt));
            ans = Math.max(ans, cnt / 2);
        }
        return ans;
    }
}
