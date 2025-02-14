package main.java.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Question: 2593. Find Score of an Array After Marking All Elements
Link: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements
 */
public class FindScoreOfAnArrayAfterMarkingAllElements_2593 {
    public static void main(String[] args) {
        var obj = new FindScoreOfAnArrayAfterMarkingAllElements_2593();
//        System.out.println(obj.findScore(new int[]{2, 1, 3, 4, 5, 2}));
//        System.out.println(obj.findScore(new int[]{2, 3, 5, 1, 3, 2}));
        System.out.println(obj.findScore(new int[]{2, 5, 6, 6, 10}));
    }

    public long findScore(int[] nums) {
        Queue<Element> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(new Element(nums[i], i));
        }

        long result = 0;
        while (!queue.isEmpty()) {
            Element poll = queue.poll();
            if (nums[poll.index] != 0) {
                result += poll.score;
                if (poll.index > 0) {
                    nums[poll.index - 1] = 0;
                }
                if (poll.index < nums.length - 1) {
                    nums[poll.index + 1] = 0;
                }
            }
        }
        return result;
    }

    static class Element implements Comparable<Element> {
        int score;
        int index;

        public Element(int score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Element o) {
            int res = Integer.compare(this.score, o.score);
            if (res == 0) {
                return Integer.compare(this.index, o.index);
            }
            return res;
        }
    }
}
