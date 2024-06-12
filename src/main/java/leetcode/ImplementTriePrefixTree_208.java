package main.java.leetcode;

import main.java.leetcode.common.TrieNode;

import java.util.Arrays;
import java.util.List;

public class ImplementTriePrefixTree_208 {
    public static void main(String[] args) {
        var obj = new ImplementTriePrefixTree_208_Solution();
        String[] dictionary = new String[]{"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        System.out.println(obj.replaceWords(Arrays.asList(dictionary), sentence));
    }
}


class ImplementTriePrefixTree_208_Solution {
    private final TrieNode root;

    public ImplementTriePrefixTree_208_Solution() {
        root = new TrieNode();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insertInTrie(word);
        }

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            sb.append(getPrefix(word)).append(" ");
        }
        return sb.toString().trim();
    }

    private void insertInTrie(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.endOfWord = true;
    }

    private String getPrefix(String word) {
        TrieNode current = root;
        int depth = 0;
        for (char c : word.toCharArray()) {
            if (current.endOfWord) {
                break;
            }
            if (!current.children.containsKey(c)) {
                return word;
            }
            current = current.children.get(c);
            depth++;
        }
        return depth == 0 ? word : word.substring(0, depth);
    }
}
