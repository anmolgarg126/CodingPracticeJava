package main.java.leetcode;

import java.util.*;

/*
Question: 884. Uncommon Words from Two Sentences
Link: https://leetcode.com/problems/uncommon-words-from-two-sentences
 */
public class UncommonWordsFromTwoSentences_884 {
    public static void main(String[] args) {
        var obj = new UncommonWordsFromTwoSentences_884();
        System.out.println(Arrays.toString(obj.uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split("\\s+")) {
            map.merge(s, 1, Integer::sum);
        }

        for (String s : s2.split("\\s+")) {
            map.merge(s, 1, Integer::sum);
        }

        List<String> result = new LinkedList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                result.add(key);
            }
        }
        return result.toArray(new String[0]);
    }
}
