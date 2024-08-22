package main.java.leetcode;

import java.util.Stack;

/*
Question: 1717. Maximum Score From Removing Substrings
Link: https://leetcode.com/problems/maximum-score-from-removing-substrings
 */
public class MaximumScoreFromRemovingSubstrings_1717 {
    public static void main(String[] args) {
        var obj = new MaximumScoreFromRemovingSubstrings_1717();
        System.out.println(obj.maximumGain("cdbcbbaaabab", 4, 5));
    }

    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() == 'a') {
                char c = stack.pop();
                if (stack.peek() == 'b') {
                    stack.pop();
                    result += y;
                }
            }
        }

        return result;
    }
}
