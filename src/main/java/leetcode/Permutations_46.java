package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Question: 46. Permutations
Link: https://leetcode.com/problems/permutations
 */
public class Permutations_46 {
    public static void main(String[] args) {
        var obj = new Permutations_46();
        System.out.println(obj.permute(new int[]{1, 2, 3}));
        System.out.println(obj.permute(new int[]{0, 1}));
        System.out.println(obj.permute(new int[]{1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        for (int num : nums) {
            curr.add(num);
        }
        return recursion(curr);
    }

    private List<List<Integer>> recursion(List<Integer> curr) {
        List<List<Integer>> result = new ArrayList<>();
        if (curr.size() == 1) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(curr));
            return res;
        }
        for (int i = 0; i < curr.size(); i++) {
            int temp = curr.remove(0);
            List<List<Integer>> newRes = recursion(curr);

            for (List<Integer> newCurr : newRes) {
                newCurr.add(temp);
            }
            result.addAll(newRes);
            curr.add(temp);
        }
        return result;
    }
}
