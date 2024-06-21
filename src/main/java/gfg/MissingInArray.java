package main.java.gfg;

/*
Question: Missing in Array
Link: https://www.geeksforgeeks.org/problems/missing-number-in-array1416
 */
public class MissingInArray {
    public static void main(String[] args) {
        var obj = new MissingInArray();
        System.out.println(obj.missingNumber(5, new int[]{1, 2, 3, 5}));
    }

    int missingNumber(int n, int[] arr) {
        // Your Code Here
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = result ^ (i) ^ arr[i - 1];
        }

        return result ^ n;

    }
}
