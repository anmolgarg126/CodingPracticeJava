package main.java.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WayTooLongWords71A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String s = br.readLine().trim();
            sb.append(getWord(s));
            if (t > 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static String getWord(String s) {
        if (s.length() > 10) {
            return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
        }
        return s;
    }
}
