package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Question: 2273. Find Resultant Array After Removing Anagrams
Link: https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/
 */
public class FindResultantArrayAfterRemovingAnagrams_2273 {
    public static void main(String[] args) {
        var obj = new FindResultantArrayAfterRemovingAnagrams_2273();
        System.out.println(obj.removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"}));
    }


    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int n = words.length;
        for (int i = 1; i < n; i++) {
            if (!isAnagram(words[i], words[i - 1])) {
                res.add(words[i]);
            }
        }
        return res;
    }

    // determine if two words are anagrams
    private boolean isAnagram(String word1, String word2) {
        int[] freq = new int[26];
        for (char ch : word1.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            freq[ch - 'a']--;
        }
        for (int x : freq) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
