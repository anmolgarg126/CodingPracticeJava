package main.java.codingstudio.codingninja;

/*
Question: N-th Fibonacci Number
Link: https://www.naukri.com/code360/problems/nth-fibonacci-number_1115780
 */
public class NthFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacciNumber(5));
        System.out.println(fibonacciNumber(7));
        System.out.println(fibonacciNumber(10));
        System.out.println(fibonacciNumber(95));
    }

    public static int fibonacciNumber(int n) {
        // Write your code here.
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int mod = 1000000007;
        int a = 0;
        int b = 1;
        int c;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return b;
    }
}
