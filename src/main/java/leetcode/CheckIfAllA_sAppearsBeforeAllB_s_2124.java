package main.java.leetcode;

import java.util.Stack;

/*
Question: 2124. Check if All A's Appears Before All B's
Link: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs
 */
public class CheckIfAllA_sAppearsBeforeAllB_s_2124 {
    public static void main(String[] args) {
        var obj = new CheckIfAllA_sAppearsBeforeAllB_s_2124();
        System.out.println(obj.checkString("aaabbb"));
        System.out.println(obj.checkString("abab"));
        System.out.println(obj.checkString("bbb"));
    }


    public boolean checkString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                return false;
            }
            stack.push(c);
        }
        return true;
    }
}
