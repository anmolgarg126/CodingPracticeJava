package main.java.leetcode;

/*
Question: 37. Sudoku Solver
Link: https://leetcode.com/problems/sudoku-solver
 */
public class SudokuSolver_37 {
    public static void main(String[] args) {
        var obj = new SudokuSolver_37();
        obj.testCase1();
    }

    private void testCase1() {
        String[][] input = new String[][]{{"5", "3", ".", ".", "7", ".", ".", ".", "."}, {"6", ".", ".", "1", "9", "5", ".", ".", "."}, {".", "9", "8", ".", ".", ".", ".", "6", "."}, {"8", ".", ".", ".", "6", ".", ".", ".", "3"}, {"4", ".", ".", "8", ".", "3", ".", ".", "1"}, {"7", ".", ".", ".", "2", ".", ".", ".", "6"}, {".", "6", ".", ".", ".", ".", "2", "8", "."}, {".", ".", ".", "4", "1", "9", ".", ".", "5"}, {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        printSudoku(input);
    }

    private void printSudoku(String[][] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                sb.append(input[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void solveSudoku(char[][] board) {

    }


}
