package main.java.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
Question: 739. Daily Temperatures
Link: https://leetcode.com/problems/daily-temperatures/description/
 */
public class DailyTemperatures_739 {
    public static void main(String[] args) {
        var obj = new DailyTemperatures_739();
        System.out.println(Arrays.toString(obj.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(obj.dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    // with stack
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                temperatures[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            temperatures[stack.pop()] = 0;
        }
        return temperatures;
    }

    // with sorting
    public int[] dailyTemperatures2(int[] temperatures) {
        Queue<Temp> queue = new PriorityQueue<>((a, b) -> a.temp - b.temp);
        for (int i = 0; i < temperatures.length; i++) {
            queue.add(new Temp(temperatures[i], i));
            while (!queue.isEmpty() && queue.peek().temp < temperatures[i]) {
                Temp prev = queue.poll();
                temperatures[prev.index] = i - prev.index;
            }
        }
        while (!queue.isEmpty()) {
            Temp temp = queue.poll();
            temperatures[temp.index] = 0;
        }
        return temperatures;
    }

    record Temp(int temp, int index) {
    }
}
