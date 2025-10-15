package main.java.leetcode;

import java.util.List;

/*
Question: 3349. Adjacent Increasing Subarrays Detection I
Link: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description
 */
public class AdjacentIncreasingSubarraysDetection1_3349 {
    public static void main(String[] args) {
        var obj = new AdjacentIncreasingSubarraysDetection1_3349();
        System.out.println(obj.hasIncreasingSubarrays(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
        System.out.println(obj.hasIncreasingSubarrays(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5));
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
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
        return ans >= k;
    }
}
