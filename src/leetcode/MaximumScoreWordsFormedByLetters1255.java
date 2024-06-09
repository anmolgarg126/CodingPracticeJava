package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumScoreWordsFormedByLetters1255 {
    int[] freq = new int[26];
    int res = 0;

    public static void main(String[] args) {
        String[] words = new String[]{"dog", "cat", "dad", "good"};
//        String[] words = new String[]{"xxxz", "ax", "bx", "cx"};
        char[] letters = new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
//        char[] letters = new char[]{'a', 'b', 'c', 'z', 'x', 'x', 'x'};
        int[] score = new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[] score = new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};

        var obj = new MaximumScoreWordsFormedByLetters1255();
//        System.out.println(obj.maxScoreWords(words, letters, score));
        System.out.println(findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6));
    }

    static int findPlatform(int[] arr, int[] dep, int n) {
        // add your code here
        Timing[] timing = new Timing[n];

        for (int i = 0; i < n; i++) {
            timing[i] = new Timing(arr[i], dep[i]);
        }

        Arrays.sort(timing, Comparator.comparing(t -> t.arr));


        int platforms = 0, res = 0, l = 0, r = 0;

        while (r < n) {
            while (timing[r].arr > timing[l].dep) {
                l++;
                platforms = Math.max(0, platforms - 1);
            }
            if (timing[r].arr < timing[l].dep) {
                platforms++;
            }
            res = Math.max(res, platforms);
            r++;
        }


        return platforms;

    }

    static class Timing {
        int arr;
        int dep;

        public Timing(int arr, int dep) {
            this.arr = arr;
            this.dep = dep;
        }

    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for (char c : letters) {
            freq[c - 'a']++;
        }

        dfs(words, score, 0, 0);
        return res;
    }

    private void dfs(String[] words, int[] score, int index, int currScore) {
        if (index >= words.length) {
            res = Math.max(currScore, res);
            return;
        }

        if (canAddThisWord(words[index])) {
            int tempScore = addThisWord(words[index], score);
            dfs(words, score, index + 1, currScore + tempScore);
            removeThisWord(words[index]);
        }

        dfs(words, score, index + 1, currScore);

    }

    private boolean canAddThisWord(String word) {
        int[] temp = new int[26];
        for (char c : word.toCharArray()) {
            if (freq[c - 'a'] < (temp[c - 'a'] + 1)) {
                return false;
            }
            temp[c - 'a']++;
        }
        return true;
    }

    private int addThisWord(String word, int[] score) {
        int tempScore = 0;

        for (char c : word.toCharArray()) {
            tempScore += score[c - 'a'];
            freq[c - 'a']--;
        }

        return tempScore;
    }

    private void removeThisWord(String word) {
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
    }

}
