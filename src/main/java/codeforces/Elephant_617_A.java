package main.java.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Elephant_617_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int result = 0;

        result += input / 5;
        input = input % 5;

        result += input / 4;
        input = input % 4;

        result += input / 3;
        input = input % 3;

        result += input / 2;
        input = input % 2;

        result += input;

        System.out.println(result);

    }
}
