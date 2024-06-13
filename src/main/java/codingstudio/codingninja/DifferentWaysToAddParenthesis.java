package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis {
    public static void main(String[] args) {
        String S = "1+2*3+1";
        List<Integer> results = diffWaysToCompute(S);
        System.out.println(results);  // Output should be [4, 2] or [2, 4]
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        return computeWays(expression);
    }

    private static List<Integer> computeWays(String expr) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // Split the expression into two parts
                String leftExpr = expr.substring(0, i);
                String rightExpr = expr.substring(i + 1);

                // Recursively compute results for both parts
                List<Integer> leftResults = computeWays(leftExpr);
                List<Integer> rightResults = computeWays(rightExpr);

                // Combine results from both parts using the operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') {
                            results.add(left + right);
                        } else if (c == '-') {
                            results.add(left - right);
                        } else if (c == '*') {
                            results.add(left * right);
                        }
                    }
                }
            }
        }

        // If the expression is a single number, convert it to integer and add to results
        if (results.isEmpty()) {
            results.add(Integer.parseInt(expr));
        }

        return results;
    }
}
