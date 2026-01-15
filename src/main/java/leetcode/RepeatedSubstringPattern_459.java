package main.java.leetcode;

/*
Question: 459. Repeated Substring Pattern
Link: https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern_459 {
    public static void main(String[] args) {
        var obj = new RepeatedSubstringPattern_459();
        System.out.println(obj.repeatedSubstringPattern("abab"));
        System.out.println(obj.repeatedSubstringPattern("aba"));
        System.out.println(obj.repeatedSubstringPattern("abcabcabcabc"));
    }

    /*
    create a new string by doubling the original string and then checks whether
    the original string is a substring of the doubled string excluding the
    first and last characters
     */
    public boolean repeatedSubstringPattern(String s) {
        String concatenate = s + s;
        return concatenate.substring(1, concatenate.length() - 1).contains(s);
    }
}
