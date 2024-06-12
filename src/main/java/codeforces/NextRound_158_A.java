package main.java.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextRound_158_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split("\\s+");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        nextRound_158_A_Solution(n, arr, k);
    }

    private static void nextRound_158_A_Solution(int n, int[] arr, int k) {
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] < arr[k - 1]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(n);
    }
}
