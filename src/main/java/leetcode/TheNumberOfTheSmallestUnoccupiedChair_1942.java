package main.java.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Question: 1942. The Number of the Smallest Unoccupied Chair
Link: https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair
 */
public class TheNumberOfTheSmallestUnoccupiedChair_1942 {
    public static void main(String[] args) {
        var obj = new TheNumberOfTheSmallestUnoccupiedChair_1942();
        System.out.println(obj.smallestChair(new int[][]{{1, 4}, {2, 3}, {4, 6}}, 1));
        System.out.println(obj.smallestChair(new int[][]{{3, 10}, {1, 5}, {2, 6}}, 0));
        System.out.println(obj.smallestChair(new int[][]{{4, 5}, {12, 13}, {5, 6}, {1, 2}, {8, 9}, {9, 10}, {6, 7}, {3, 4}, {7, 8}, {13, 14}, {15, 16}, {14, 15}, {10, 11}, {11, 12}, {2, 3}, {16, 17}}, 15));
        System.out.println(obj.smallestChair(new int[][]{{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310}, {78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856}, {98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821}, {48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}}, 6));
    }

    static class Person {
        int arrival;
        int departure;
        int chair;
        int index;

        public Person(int arrival, int departure, int chair, int index) {
            this.arrival = arrival;
            this.departure = departure;
            this.chair = chair;
            this.index = index;
        }

        @Override
        public String toString() {
            return arrival + "," + departure;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.offer(i);
        }

        PriorityQueue<Person> usedChairs = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.departure, o2.departure));
        Person[] input = new Person[n];
        for (int i = 0; i < times.length; i++) {
            input[i] = new Person(times[i][0], times[i][1], 0, i);
        }

        Arrays.sort(input, (o1, o2) -> Integer.compare(o1.arrival, o2.arrival));

        for (Person p : input) {
            while (!usedChairs.isEmpty() && usedChairs.peek().departure <= p.arrival) {
                Person person = usedChairs.poll();
                availableChairs.offer(person.chair);
            }
            int currChair = availableChairs.poll();
            if (p.index == targetFriend) {
                return currChair;
            }
            usedChairs.offer(new Person(p.arrival, p.departure, currChair, 0));
        }
        return -1;
    }
}
