package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow("a", "a"));
//        System.out.println(minWindow("ab", "b"));
        System.out.println(minWindow("timetopractice", "toc"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() ||
                s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.merge(c, 1, Integer::sum);
        }


        int l = 0, r = 0, have = 0, need = countT.size(), si = -1, minLen = Integer.MAX_VALUE;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (countT.containsKey(c)) {
                int w = window.getOrDefault(c, 0);
                if (w < countT.get(c) && (w + 1) == countT.get(c)) {
                    have++;
                }
                window.merge(c, 1, Integer::sum);
            }

            while (l <= r && have == need) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    si = l;
                }
                char curr = s.charAt(l);
                if (countT.containsKey(curr)) {
                    int w = window.get(curr);
                    if (w == countT.get(curr)) {
                        have--;
                    }
                    window.put(curr, w - 1);
                }
                l++;
            }
            r++;
        }
        return si == -1 ? "" : s.substring(si, si + minLen);
    }
}
