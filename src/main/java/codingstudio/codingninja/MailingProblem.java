package main.java.codingstudio.codingninja;

import java.util.HashMap;
import java.util.Map;

/*
Question:  Mailing Problem
Link:
 */
public class MailingProblem {

    public static void main(String[] args) {
        System.out.println(timeTakenToMail("qwertyuiopasdfghjklzxcvbnm", "perry"));
        System.out.println(timeTakenToMail("abcdefghijklmnopqrstuvwxyz", "abc"));
        System.out.println(timeTakenToMail("zyxwvutsrqponmlkjihgfedcba", "zayb"));
    }

    public static int timeTakenToMail(String keyboard, String s) {
        // Write your code here.
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }

        int res = 0, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer curr = map.get(s.charAt(i));
            res += Math.abs(curr - prev);
            prev = curr;
        }
        return res;
    }

}
