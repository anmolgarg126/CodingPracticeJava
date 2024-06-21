package main.java.gfg;

import java.util.LinkedList;
import java.util.Queue;

/*
Question: Stack using two queues
Link: https://www.geeksforgeeks.org/problems/stack-using-two-queues
 */
public class StackUsingTwoQueues {
    public static void main(String[] args) {
        var obj = new StackUsingTwoQueues();
        obj.testCase1();
        obj.testCase2();
    }

    private void testCase1() {
        System.out.println("*************** testCase1() ***************");
        var queues = new Queues();
        queues.push(2);
        queues.push(3);
        System.out.print(queues.pop() + " ");
        queues.push(4);
        System.out.print(queues.pop() + " ");
        System.out.println();
    }

    private void testCase2() {
        System.out.println("*************** testCase2() ***************");
        var queues = new Queues();
        queues.push(2);
        System.out.print(queues.pop() + " ");
        System.out.print(queues.pop() + " ");
        queues.push(3);
        System.out.println();
    }

    static class Queues {
        Queue<Integer> q1 = new LinkedList<Integer>();
        // Queue<Integer> q2 = new LinkedList<Integer>();

        //Function to push an element into stack using two queues.
        void push(int a) {
            // Your code here
            q1.add(a);
        }

        //Function to pop an element from stack using two queues.
        int pop() {
            int n = q1.size();
            if (n == 0) {
                return -1;
            }
            for (int i = 0; i < n - 1; i++) {
                q1.add(q1.poll());
            }
            return q1.poll();
        }

    }
}
