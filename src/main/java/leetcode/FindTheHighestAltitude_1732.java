package main.java.leetcode;

/*
Question: 1732. Find the Highest Altitude
Link: https://leetcode.com/problems/find-the-highest-altitude/
 */
public class FindTheHighestAltitude_1732 {
    public static void main(String[] args) {
        var obj = new FindTheHighestAltitude_1732();
        System.out.println(obj.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(obj.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public int largestAltitude(int[] gain) {
        int max = Math.max(0, gain[0]);
        for (int i = 1; i < gain.length; i++) {
            gain[i] += gain[i - 1];
            max = Math.max(max, gain[i]);
        }
        return max;
    }
}
