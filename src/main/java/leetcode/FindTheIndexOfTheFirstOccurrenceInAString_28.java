package main.java.leetcode;

/*
Question: 28. Find the Index of the First Occurrence in a String
Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 */
public class FindTheIndexOfTheFirstOccurrenceInAString_28 {
    public static void main(String[] args) {
        var obj = new FindTheIndexOfTheFirstOccurrenceInAString_28();
        System.out.println(obj.strStr("sadbutsad", "sad"));
        System.out.println(obj.strStr("leetcode", "leeto"));
        System.out.println(obj.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        int index = 0;
        int i = 0;
        for (; i < haystack.length() && index < needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                index++;
            } else {
                i = i - index;
                index = 0;
            }
        }
        return index == needle.length() ? i - needle.length() : -1;
    }
}
