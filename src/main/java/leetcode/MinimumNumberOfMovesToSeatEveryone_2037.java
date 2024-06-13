package main.java.leetcode;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone_2037 {
    public static void main(String[] args) {
        var obj = new MinimumNumberOfMovesToSeatEveryone_2037();
        obj.testCase1();
        obj.testCase2();
        obj.testCase3();
    }

    private void testCase1() {
        int[] seats = {3, 1, 5};
        int[] students = {2, 7, 4};
        System.out.println(minMovesToSeat(seats, students));
    }

    private void testCase2() {
        int[] seats = {4, 1, 5, 9};
        int[] students = {1, 3, 2, 6};
        System.out.println(minMovesToSeat(seats, students));
    }

    private void testCase3() {
        int[] seats = {2, 2, 6, 6};
        int[] students = {1, 3, 2, 6};
        System.out.println(minMovesToSeat(seats, students));
    }


    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;

        for (int i = 0; i < seats.length; i++) {
            count += Math.abs(seats[i] - students[i]);
        }

        return count;
    }
}
