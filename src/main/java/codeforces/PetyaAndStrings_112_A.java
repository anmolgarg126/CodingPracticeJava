package main.java.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PetyaAndStrings_112_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        petyaAndStrings_112_A_Solution(a, b);
    }

    private static void petyaAndStrings_112_A_Solution(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (Character.toLowerCase(a.charAt(i)) < Character.toLowerCase(b.charAt(i))) {
                System.out.println("-1");
                return;
            } else if (Character.toLowerCase(a.charAt(i)) > Character.toLowerCase(b.charAt(i))) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
}
