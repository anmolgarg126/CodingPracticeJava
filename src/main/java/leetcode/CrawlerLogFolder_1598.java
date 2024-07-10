package main.java.leetcode;

import java.util.Stack;

/*
Question: 1598. Crawler Log Folder
Link: https://leetcode.com/problems/crawler-log-folder
 */
public class CrawlerLogFolder_1598 {
    public static void main(String[] args) {
        var obj = new CrawlerLogFolder_1598();
        System.out.println(obj.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(obj.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(obj.minOperations(new String[]{"d1/", "../", "../", "../"}));
    }

    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String s : logs) {
            if (s.equals("./")) {
                continue;
            } else if (s.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.substring(0, s.length() - 1));
            }
        }
        return stack.size();
    }
}
