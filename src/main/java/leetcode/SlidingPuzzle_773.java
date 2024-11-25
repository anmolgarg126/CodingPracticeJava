package main.java.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Question: 773. Sliding Puzzle
Link: https://leetcode.com/problems/sliding-puzzle
Explanation: https://www.youtube.com/watch?v=Sl_HEbFDJBs&t=1207s
 */
public class SlidingPuzzle_773 {
    public static void main(String[] args) {
        var obj = new SlidingPuzzle_773();
        System.out.println(obj.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println(obj.slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(obj.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));

    }

    public int slidingPuzzle(int[][] board) {
        String currentState = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                currentState = currentState + board[i][j];
            }
        }

        String targetState = "123450";

        Queue<String> queue = new LinkedList<>();
        queue.add(currentState);

        Set<String> visited = new HashSet<>();
        visited.add(currentState);

        int[][] directions = new int[][]{
                {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}
        };

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                currentState = queue.poll();

                if (currentState.equals(targetState)) {
                    return level;
                }

                // Find position of zero in the string to slide
                int zeroPos = currentState.indexOf('0');

                // Try all 4 directions to unvisited states only
                for (int pos : directions[zeroPos]) {
                    String newState = swap(currentState, zeroPos, pos);
                    if (!visited.contains(newState)) {
                        queue.add(newState);
                        visited.add(newState);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private String swap(String str, int pos1, int pos2) {
        char[] charArray = str.toCharArray();
        char temp = charArray[pos1];
        charArray[pos1] = charArray[pos2];
        charArray[pos2] = temp;
        return new String(charArray);
    }


}
