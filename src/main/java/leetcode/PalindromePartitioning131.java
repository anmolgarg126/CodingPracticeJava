package main.java.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning131 {
    public static void main(String[] args) {
        var palindromePartitioning131 = new PalindromePartitioning131();
        System.out.println(palindromePartitioning131.partition("aab"));
    }

    List<List<String>> result = new LinkedList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new LinkedList<>(), 0);
        return result;
    }

    private void dfs(String s, List<String> prev, int index) {
        if (index >= s.length()) {
            result.add(new LinkedList<>(prev));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                prev.add(s.substring(index, i + 1));
                dfs(s, prev, i + 1);
                prev.remove(prev.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
