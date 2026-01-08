package main.java.leetcode;

import java.util.Stack;

/*
Question: 84. Largest Rectangle in Histogram
Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram_84 {
    public static void main(String[] args) {
        var obj = new LargestRectangleInHistogram_84();
        System.out.println(obj.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(obj.largestRectangleArea(new int[]{2, 4}));
        System.out.println(obj.largestRectangleArea(new int[]{2,1,2}));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Bar> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int lastIndex = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                Bar bar = stack.pop();
                maxArea = Math.max(maxArea, bar.height * (i - bar.index));
                lastIndex = bar.index;
            }
            stack.push(new Bar(heights[i], lastIndex));
        }
        while (!stack.isEmpty()) {
            Bar bar = stack.pop();
            maxArea = Math.max(maxArea, bar.height * (n - bar.index));
        }
        return maxArea;
    }

    record Bar(int height, int index) {
    }
}
