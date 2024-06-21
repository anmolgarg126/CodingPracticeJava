package main.java.gfg;

/*
Question: Equilibrium Point
Link: https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620
 */
public class EquilibriumPoint {
    public static void main(String[] args) {
        System.out.println(equilibriumPoint(new long[]{1, 3, 5, 2, 2}, 5));
    }

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long[] arr, int n) {

        // Your code here
        long[] left = new long[n];
        long[] right = new long[n];

        for (int i = 1; i < n; i++) {
            left[i] += left[i - 1] + arr[i - 1];
            right[n - 1 - i] += right[n - i] + arr[n - i];
        }

        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}
