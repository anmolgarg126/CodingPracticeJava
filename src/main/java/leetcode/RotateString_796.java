package main.java.leetcode;

/*
Question: 796. Rotate String
Link: https://leetcode.com/problems/rotate-string/
 */
public class RotateString_796 {
    public static void main(String[] args) {
        var obj = new RotateString_796();
        System.out.println(obj.rotateString("abcde", "cdeab"));
        System.out.println(obj.rotateString("abcde", "abced"));
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
