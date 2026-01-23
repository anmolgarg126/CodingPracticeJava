package main.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/*
Question: 3507. Minimum Pair Removal to Sort Array I
Link: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/
 */
public class MinimumPairRemovalToSortArray_I_3507 {
    public static void main(String[] args) {
        var obj = new MinimumPairRemovalToSortArray_I_3507();
        System.out.println(obj.minimumPairRemoval(new int[]{1, 2, 3, 4, 5}));
        System.out.println(obj.minimumPairRemoval(new int[]{5, 2, 3, 1}));
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int count = 0;
        while (list.size() > 1) {
            boolean sorted = true;
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    sorted = false;
                }

                int sum = list.get(i) + list.get(i + 1);
                if (sum < min) {
                    min = sum;
                    index = i;
                }
            }
            if (sorted) {
                break;
            }

            list.set(index, min);
            list.remove(index + 1);
            count++;
        }
        return count;
    }
}
