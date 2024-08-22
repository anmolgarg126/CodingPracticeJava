package main.java.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Question: 2418. Sort the People
Link: https://leetcode.com/problems/sort-the-people
 */
public class SortThePeople_2418 {
    public static void main(String[] args) {
        var obj = new SortThePeople_2418();
        System.out.println(Arrays.toString(obj.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        Queue<People> peopleQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.height, a.height));
        for (int i = 0; i < names.length; i++) {
            peopleQueue.add(new People(heights[i], names[i]));
        }
        String[] result = new String[peopleQueue.size()];
        for (int i = 0; i < names.length && !peopleQueue.isEmpty(); i++) {
            result[i] = peopleQueue.poll().name;
        }
        return result;
    }

    static class People {
        int height;
        String name;

        public People(int height, String name) {
            this.height = height;
            this.name = name;
        }
    }
}
