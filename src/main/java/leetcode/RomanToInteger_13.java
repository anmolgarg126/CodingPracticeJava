package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Question: 13. Roman to Integer
Link: https://leetcode.com/problems/roman-to-integer
 */
public class RomanToInteger_13 {
    public static void main(String[] args) {
        var obj = new RomanToInteger_13();
        System.out.println(obj.romanToInt("III"));
        System.out.println(obj.romanToInt("LVIII"));
        System.out.println(obj.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;

        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (i == s.length() - 1) {
                result += curr;
            } else {
                if (curr < prev) {
                    result -= curr;
                } else {
                    result += curr;
                }
            }
            prev = curr;
        }
        return result;
    }
}
