package main.java.leetcode;

/*
Question: 8. String to Integer (atoi)
Link: https://leetcode.com/problems/string-to-integer-atoi
 */
public class StringToInteger_8 {
    public static void main(String[] args) {
        var obj = new StringToInteger_8();
        System.out.println(obj.myAtoi("42"));
        System.out.println(obj.myAtoi(" -042"));
        System.out.println(obj.myAtoi("1337c0d3"));
        System.out.println(obj.myAtoi("0-1"));
        System.out.println(obj.myAtoi("words and 987"));
        System.out.println(obj.myAtoi("-91283472332"));
    }

    public int myAtoi(String s) {
        int i = 0, sign = 1, n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) { // Check for optional sign
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i)) && num <= Integer.MAX_VALUE) {
            num = num * 10 + s.charAt(i) - '0';
            i++;
        }

        num = Math.max(sign * num, Integer.MIN_VALUE);
        num = Math.min(num, Integer.MAX_VALUE);
        return (int) num;
    }
}
