package main.java.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Question: Maximize movie ratings
Link: https://www.hackerearth.com/problem/algorithm/maximize-movie-ratings-1-9f4171c6-8648e75d-33afe308-972d4254/
 */
public class MaximizeMovieRatings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine().split("\\s+")[1]);
        String[] temp = br.readLine().split("\\s+");
        System.out.println(maximizeRating(temp, k));
    }

    private static int maximizeRating(String[] temp, int k) {
        int[] input = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            input[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(input);

        int min = Integer.MAX_VALUE, minI = 0;

        for (int i = 0; i < temp.length; i++) {
            if (k > 0 && input[i] < 0) {
                input[i] = -input[i];
                k--;
            }
            if (input[i] < min) {
                min = input[i];
                minI = i;
            }
        }

        if (k % 2 == 1) {
            input[minI] = -input[minI];
        }


        int res = 0;
        for (int j : input) {
            res += j;
        }
        return res;
    }
}
