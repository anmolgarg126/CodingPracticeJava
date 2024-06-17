package main.java.leetcode;

/*
Question: 633. Sum of Square Numbers
Link: https://leetcode.com/problems/sum-of-square-numbers
 */
public class SumOfSquareNumbers_633 {
    public static void main(String[] args) {
        var obj = new SumOfSquareNumbers_633();
        System.out.println(obj.judgeSquareSum(3));
        System.out.println(obj.judgeSquareSum(5));
        System.out.println(obj.judgeSquareSum(2147483600));
    }

    public boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int) Math.ceil(Math.sqrt(c));

        while (start <= end) {
            int sq = (start * start) + (end * end);
            if (sq == c) {
                return true;
            } else if (sq > c || sq < 0) { // to check for integer overflow
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
