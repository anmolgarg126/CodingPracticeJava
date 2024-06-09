package main.java.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Team_231_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int res = 0;

        while (t-- > 0) {
            String[] input = br.readLine().split("\\s+");
            int temp = 0;

            for (String s : input) {
                if (s.equals("1")) {
                    temp++;
                }
            }

            if (temp > 1) {
                res++;
            }
        }
        System.out.println(res);
    }
}
