package main.java.leetcode;

/*
Question: 1701. Average Waiting Time
Link: https://leetcode.com/problems/average-waiting-time
 */
public class AverageWaitingTime_1701 {
    public static void main(String[] args) {
        var obj = new AverageWaitingTime_1701();
        System.out.println(obj.averageWaitingTime(new int[][]{{1, 2}, {2, 5}, {4, 3}}));
        System.out.println(obj.averageWaitingTime(new int[][]{{5, 2}, {5, 4}, {10, 3}, {20, 1}}));
    }

    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        long currentTime = 0;

        for (int[] customer : customers) {
            if (currentTime >= customer[0]) {
                currentTime += customer[1];
                totalWaitingTime += currentTime - customer[0];
            } else {
                totalWaitingTime += customer[1];
                currentTime = customer[0] + customer[1];
            }
        }
        return totalWaitingTime * 1.0d / customers.length;
    }
}
