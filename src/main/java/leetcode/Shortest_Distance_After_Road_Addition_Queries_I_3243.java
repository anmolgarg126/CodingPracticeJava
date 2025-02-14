package main.java.leetcode;

import java.util.Arrays;

/*
Question: 3243. Shortest Distance After Road Addition Queries I
Link: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i
 */
public class Shortest_Distance_After_Road_Addition_Queries_I_3243 {
    public static void main(String[] args) {
        var obj = new Shortest_Distance_After_Road_Addition_Queries_I_3243();
//        System.out.println(Arrays.toString(obj.shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}})));
//        System.out.println(Arrays.toString(obj.shortestDistanceAfterQueries(4, new int[][]{{0, 3}, {0, 2}})));
        System.out.println(Arrays.toString(obj.shortestDistanceAfterQueries(6, new int[][]{{1, 3}, {3, 5}})));
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            path[n - i - 1] = i;
        }

        for (int i = 0; i < queries.length; i++) {
            path[queries[i][0]] = Math.min(path[queries[i][0]], path[queries[i][1]] + 1);

            for (int j = queries[i][0] - 1; j >= 0; j--) {
                path[j] = Math.min(path[j], path[j + 1] + 1);
            }

            result[i] = path[0];
        }
        return result;
    }
}
