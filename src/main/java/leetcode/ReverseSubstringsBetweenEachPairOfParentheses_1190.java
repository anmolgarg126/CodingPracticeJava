package main.java.leetcode;

import java.util.Stack;

/*
Question: 1190. Reverse Substrings Between Each Pair of Parentheses
Link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses
 */
public class ReverseSubstringsBetweenEachPairOfParentheses_1190 {
    public static void main(String[] args) {
        var obj = new ReverseSubstringsBetweenEachPairOfParentheses_1190();
        System.out.println(obj.reverseParentheses("(abcd)"));
        System.out.println(obj.reverseParentheses("(u(love)i)"));
        System.out.println(obj.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(obj.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public String reverseParentheses(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(res.length());
            } else if (c == ')' && !stack.isEmpty()) {
                int startIndex = stack.pop();
                String reversed = new StringBuilder(res.substring(startIndex)).reverse().toString();
                res.replace(startIndex, res.length(), reversed);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
