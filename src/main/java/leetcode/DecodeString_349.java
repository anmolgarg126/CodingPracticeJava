package main.java.leetcode;

import java.util.Stack;

/*
Question: 394. Decode String
Link: https://leetcode.com/problems/decode-string
 */
public class DecodeString_349 {
    public static void main(String[] args) {
        var obj = new DecodeString_349();
        System.out.println(obj.decodeString("3[a]2[bc]"));
        System.out.println(obj.decodeString("3[a2[c]]"));
        System.out.println(obj.decodeString("2[abc]3[cd]ef"));
        System.out.println(obj.decodeString("100[leetcode]"));
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                stack.pop();
                StringBuilder intTimes = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    intTimes.append(stack.pop());
                }
                int times = Integer.parseInt(intTimes.reverse().toString());

                while (times-- > 0) {
                    for (int j = temp.length() - 1; j >= 0; j--) {
                        stack.push(temp.charAt(j));
                    }
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
