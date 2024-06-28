package main.java.gfg;

import java.util.HashMap;
import java.util.Map;

/*
Question: Smallest window in a string containing all the characters of another string
Link: https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621
 */
public class SmallestWindowInAStringContainingAllTheCharactersOfAnotherString {
    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc"));
        System.out.println(smallestWindow("zoomlazapzo", "oza"));
    }

    public static String smallestWindow(String s, String p) {
        // Your code here

        if (s == null || p == null || s.isEmpty() || p.isEmpty() || s.length() < p.length()) {
            return "-1";
        }

        Map<Character, Integer> countP = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            countP.merge(c, 1, Integer::sum);
        }

        int l = 0, r = 0, minLength = Integer.MAX_VALUE, si = -1, have = 0, need = countP.size();

        while (r < s.length()) {
            char c = s.charAt(r);
            if (countP.containsKey(c)) {
                int w = window.getOrDefault(c, 0);
                if (w + 1 == countP.get(c)) {
                    have++;
                }
                window.put(c, w + 1);
            }

            while (l <= r && have == need) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    si = l;
                }

                char curr = s.charAt(l);

                if (countP.containsKey(curr)) {
                    int w = window.getOrDefault(curr, 0);
                    if (w == countP.get(curr)) {
                        have--;
                    }
                    window.put(curr, w - 1);
                }
                l++;
            }
            r++;
        }

        return si == -1 ? "-1" : s.substring(si, si + minLength);
    }
}
