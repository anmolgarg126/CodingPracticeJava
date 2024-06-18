package main.java.codingstudio.codingninja;

import java.util.Arrays;

/*
Question: Frog Jump
Link: https://www.naukri.com/code360/problems/frog-jump_3621012
 */
public class FrogJump {
    public static void main(String[] args) {
        System.out.println(frogJump(4, new int[]{10, 20, 30, 10}));
        System.out.println(frogJump(3, new int[]{10, 50, 10}));
        System.out.println(frogJump(43, new int[]{17, 8, 16, 2, 8, 17, 9, 8, 15, 15, 5, 10, 8, 16, 11, 8, 3, 2, 10, 18, 5, 5, 6, 4, 18, 1, 11, 8, 18, 2, 13, 8, 20, 17, 17, 9, 7, 14, 9, 11, 7, 18, 17}));
        System.out.println(frogJump(41, new int[]{14, 11, 5, 4, 2, 14, 19, 15, 3, 20, 13, 16, 5, 17, 19, 8, 18, 14, 11, 5, 4, 1, 14, 15, 13, 3, 13, 16, 5, 12, 12, 3, 7, 19, 12, 2, 6, 20, 3, 18, 8
        }));

        System.out.println(NthRoot(9, 1953125));

    }

    public static int NthRoot(int n, int m) {
        // Write your code here.
        double res = Math.pow(m, 1.0/n);

        if(Math.floor(res)==res) {
            return (int) res;
        }

        return -1;

    }
    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);

        for (int i = 2; i < n; i++) {

            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(left, right);

        }
        return dp[n - 1];
    }


}
