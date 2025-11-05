package main.java.leetcode;

/*
Question: 407. Trapping Rain Water II
Link: https://leetcode.com/problems/trapping-rain-water-ii/
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater2_407 {
    public static void main(String[] args) {
        var obj = new TrappingRainWater2_407();
        System.out.println(obj.trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
        System.out.println(obj.trapRainWater(new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}));
        System.out.println(obj.trapRainWater(new int[][]{{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}}));
    }

    /*
    Objective behind this is, corners won't be able to hold any water as they are bounded,
    middle cells will be able to hold water only if they smaller than edge cells.
     */
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparing(c -> c.height));
        int numOfRows = heightMap.length;
        int numOfCols = heightMap[0].length;

        boolean[][] visited = new boolean[numOfRows][numOfCols];

        for (int i = 0; i < numOfRows; i++) {
            if (!visited[i][0]) {
                pq.offer(new Cell(i, 0, heightMap[i][0]));
                visited[i][0] = true;
            }

            if (!visited[i][numOfCols - 1]) {
                pq.offer(new Cell(i, numOfCols - 1, heightMap[i][numOfCols - 1]));
                visited[i][numOfCols - 1] = true;
            }
        }

        // Add the first and last row cells to the boundary and mark them as visited
        for (int i = 0; i < numOfCols; i++) {
            if (!visited[0][i]) {
                pq.offer(new Cell(0, i, heightMap[0][i]));
                visited[0][i] = true;
            }
            if (!visited[numOfRows - 1][i]) {
                pq.offer(new Cell(numOfRows - 1, i, heightMap[numOfRows - 1][i]));
                visited[numOfRows - 1][i] = true;
            }
        }


        int max = 0;
        int res = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            max = Math.max(max, cell.height);
            res += max - cell.height;
            for (int i = 0; i < directions.length; i++) {
                int row = cell.row + directions[i][0];
                int col = cell.col + directions[i][1];
                while (row >= 0 && col >= 0 && row < numOfRows && col < numOfCols && !visited[row][col]) {
                    pq.offer(new Cell(row, col, heightMap[row][col]));
                    visited[row][col] = true;
                }
            }
        }
        return res;
    }

    static class Cell {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
