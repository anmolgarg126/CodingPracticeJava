package main.java.leetcode;

import java.util.Stack;

/*
Question: 232. Implement Queue using Stacks
Link: https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks_232 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        obj.push(3);
        System.out.println(obj.peek());
    }

    static class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> stack2;

        public MyQueue() {
            stack = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);

        }

        public int pop() {
            if (stack2.isEmpty()) {
                fillSec();
            }
            if (stack2.isEmpty()) {
                return -1;
            }

            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                fillSec();
            }
            if (stack2.isEmpty()) {
                return -1;
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && stack2.isEmpty();
        }

        private void fillSec() {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }
    }
}
