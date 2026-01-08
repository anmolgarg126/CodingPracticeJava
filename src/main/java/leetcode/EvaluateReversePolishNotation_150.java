package main.java.leetcode;

import java.util.Stack;

/*
Question: 150. Evaluate Reverse Polish Notation
Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation_150 {
    public static void main(String[] args) {
        var obj = new EvaluateReversePolishNotation_150();
        System.out.println(obj.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                if (token.equals("+")) {
                    stack.push(a + b);
                }
                if (token.equals("-")) {
                    stack.push(a - b);
                }
                if (token.equals("*")) {
                    stack.push(a * b);
                }
                if (token.equals("/")) {
                    stack.push(a / b);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
