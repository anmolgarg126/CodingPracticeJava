package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseTheArray {
    public static void main(String[] args) {
        testCase1();
    }

    public static void testCase1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        reverseArray(list, 3);
        System.out.println(list);
    }

    public static void reverseArray(ArrayList<Integer> arr, int m) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        for (int i = m + 1; i < arr.size(); i++) {
            stack.push(arr.get(i));
        }
        arr.subList(m + 1, arr.size()).clear();
        while (!stack.isEmpty()) {
            arr.add(stack.pop());
        }
    }
}
