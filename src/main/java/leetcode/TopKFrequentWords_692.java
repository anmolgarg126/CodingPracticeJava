package main.java.leetcode;

import java.util.*;

/*
Question: 692. Top K Frequent Words
Link: https://leetcode.com/problems/top-k-frequent-words
 */

//TODO:: not completed
public class TopKFrequentWords_692 {
    public static void main(String[] args) {
        var obj = new TopKFrequentWords_692();
        System.out.println(obj.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(obj.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        Queue<Element> elements = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            elements.add(new Element(entry.getValue(), entry.getKey()));
            if (elements.size() > k) {
                elements.poll();
            }
        }
        LinkedList<String> result = new LinkedList<>();
        int i = k - 1;
        while (i >= 0) {
            Element element = elements.poll();
            result.add(element.word);
            i--;
        }
        Collections.reverse(result);
        return result;

    }

    static class Element {
        int freq;
        String word;

        public Element(int freq, String word) {
            this.freq = freq;
            this.word = word;
        }
    }
}
