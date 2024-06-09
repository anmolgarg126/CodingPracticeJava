package main.java.gfg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestDistinctWindow {
    public static void main(String[] args) {
        SmallestDistinctWindow distinctWindow = new SmallestDistinctWindow();
        System.out.println(distinctWindow.findSubString("aabcbcdbca"));
    }
    public int findSubString(String str) {
        // Your code goes here

        if (str == null || str.isEmpty()) {
            return 0;
        }

        Set<Character> countT = new HashSet<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : str.toCharArray()) {
            countT.add(c);
        }

        int l = 0, r = 0, have = 0, need = countT.size(),  minLen = Integer.MAX_VALUE;

        while(r<str.length()) {
            char c = str.charAt(r);
            if(countT.contains(c)) {
                int w = window.getOrDefault(c,0);
                if(w==0) {
                    have++;
                }
                window.put(c,w+1);
            }

            while(have==need && l<=r) {
                if(r-l+1 < minLen) {
                    minLen = r-l+1;
                }
                char t = str.charAt(l);
                if(countT.contains(t)) {
                    int w = window.get(t);
                    if(w==1) {
                        have--;
                    }
                    window.put(t,w-1);
                }
                l++;
            }
            r++;
        }
        return minLen;
    }
}
