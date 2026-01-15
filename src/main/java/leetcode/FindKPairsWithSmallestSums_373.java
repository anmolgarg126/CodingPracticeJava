package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Question: 373. Find K Pairs with Smallest Sums
Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class FindKPairsWithSmallestSums_373 {
    public static void main(String[] args) {
        var obj = new FindKPairsWithSmallestSums_373();
        System.out.println(obj.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (!queue.isEmpty() && k-- > 0) {
            int[] cur = queue.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            queue.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}
