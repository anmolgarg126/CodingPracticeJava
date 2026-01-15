package main.java.leetcode;

import java.util.Stack;

/*
Question: 1081. Smallest Subsequence of Distinct Characters
Link: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

Question: 316. Remove Duplicate Letters
Link: https://leetcode.com/problems/remove-duplicate-letters/
 */
public class SmallestSubsequenceOfDistinctCharacters_1081 {
    public static void main(String[] args) {
        var obj = new SmallestSubsequenceOfDistinctCharacters_1081();
        System.out.println(obj.smallestSubsequence("bcabc"));
        System.out.println(obj.smallestSubsequence("cbacdcbc"));
    }

    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (seen[curr - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > curr && i < lastIndex[stack.peek() - 'a']) {
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(curr);
            seen[curr - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = carry + digits[i];
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        int[] res = new int[sb.length()];
        for (int i = sb.length() - 1; i >= 0; i--) {
            res[sb.length() - i - 1] = sb.charAt(i) - '0';
        }
        return res;
    }

}
