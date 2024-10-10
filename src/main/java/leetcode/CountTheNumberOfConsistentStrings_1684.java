package main.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Question: 1684. Count the Number of Consistent Strings
Link: https://leetcode.com/problems/count-the-number-of-consistent-strings
 */
public class CountTheNumberOfConsistentStrings_1684 {
    public static void main(String[] args) {
        var obj = new CountTheNumberOfConsistentStrings_1684();
        System.out.println(obj.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(obj.countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(obj.countConsistentStrings("cad", new String[]{"cc","acd","b","ba","bac","bad","ac","d"}));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }

        int result = 0;

        for (int i = 0; i < words.length; i++) {
            boolean found = true;
            for (char c : words[i].toCharArray()) {
                if (!set.contains(c)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                result++;
            }
        }
        return result;
    }
}
