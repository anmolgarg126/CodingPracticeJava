package main.java.other;

import java.util.HashMap;
import java.util.Map;

public class LovePercentageCalculator {
    public static void main(String[] args) {
        var obj = new LovePercentageCalculator();
        System.out.println(obj.calculateLovePercentage("adam", "eve"));

    }

    private int calculateLovePercentage(String name1, String name2) {
        String firstToSecond = name1.toLowerCase() + "love" + name2.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : firstToSecond.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        StringBuilder first = new StringBuilder();
        for (char c : firstToSecond.toCharArray()) {
            if (map.containsKey(c)) {
                first.append(map.get(c));
                map.remove(c);
            }
        }

        while (first.length() > 2) {
            StringBuilder temp = new StringBuilder();
            int l = 0, r = first.length() - 1;
            while (l < r) {
                int sum = (first.charAt(l) - '0') + (first.charAt(r) - '0');
                temp.append(sum);
                l++;
                r--;
            }
            if (l == r) {
                temp.append(first.charAt(l));
            }
            first.replace(0, first.length(), temp.toString());
        }
        return Integer.parseInt(first.toString());

    }
}