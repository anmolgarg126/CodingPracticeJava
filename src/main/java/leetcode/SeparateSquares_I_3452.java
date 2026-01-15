package main.java.leetcode;

/*
Question: 3453. Separate Squares I
Link: https://leetcode.com/problems/separate-squares-i/
 */
public class SeparateSquares_I_3452 {
    public static void main(String[] args) {
        var obj = new SeparateSquares_I_3452();
        System.out.println(obj.separateSquares(new int[][]{{0, 0, 1}, {2, 2, 1}}));
    }

    public double separateSquares(int[][] squares) {
        double totalArea = 0.0;
        double low = 2e9; // Initialize with a large value
        double high = 0;

        // 1. Calculate Total Area and initial bounds
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];

            // Cast to double BEFORE multiplying to prevent Integer Overflow
            totalArea += l * l;

            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double halfArea = totalArea / 2.0;

        // 2. Binary Search with fixed iterations
        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;

            if (calculateArea(squares, mid) >= halfArea) {
                high = mid; // Area is sufficient, try to lower the line
            } else {
                low = mid;  // Area is too small, need to raise the line
            }
        }
        return high;
    }

    private double calculateArea(int[][] squares, double currentY) {
        double area = 0;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            double top = y + l;

            if (y >= currentY) {
                // Case 1: Square is completely above the line
                continue;
            } else if (top <= currentY) {
                // Case 2: Square is completely below the line
                area += l * l;
            } else {
                // Case 3: Line cuts through the square
                // We take the width (l) * the height of the bottom portion (currentY - y)
                area += l * (currentY - y);
            }
        }
        return area;
    }
}
