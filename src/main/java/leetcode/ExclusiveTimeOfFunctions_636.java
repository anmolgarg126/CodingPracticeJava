package main.java.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Question: 636. Exclusive Time of Functions
Link: https://leetcode.com/problems/exclusive-time-of-functions/
 */
public class ExclusiveTimeOfFunctions_636 {
    public static void main(String[] args) {
        var obj = new ExclusiveTimeOfFunctions_636();
        System.out.println(Arrays.toString(obj.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
        System.out.println(Arrays.toString(obj.exclusiveTime(3, Arrays.asList("0:start:0", "0:end:0", "1:start:1", "1:end:1", "2:start:2", "2:end:2", "2:start:3", "2:end:3"))));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, time = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            int t = Integer.parseInt(s[2]);
            if (!stack.isEmpty()) {
                res[stack.peek()] += (t - time); // update to current time
            }
            time = t;
            if (s[1].equals("start")) {
                stack.push(Integer.parseInt(s[0]));
            } else {
                res[stack.pop()]++;
                time++;
            }
            i++;
        }
        return res;
    }
}
