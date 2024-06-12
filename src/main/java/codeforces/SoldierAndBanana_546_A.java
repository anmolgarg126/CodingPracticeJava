package main.java.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SoldierAndBanana_546_A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");

        soldierAndBanana_546_A_Solution(input);

    }

    private static void soldierAndBanana_546_A_Solution(String[] input) {
        // AP ka formula lagega. A=0, d = cost of first banana

        long costOfFirstBanana = Long.parseLong(input[0]), money = Long.parseLong(input[1]), bananasToBuy = Long.parseLong(input[2]);

        // here a=0, d=costOfFirstBanana, n = bananasToBuy+1
        long a = 0;
        long nthTerm = a + (bananasToBuy) * costOfFirstBanana;

        long totalMoneyRequired = ((bananasToBuy + 1) * (a + nthTerm)) / 2;

        System.out.println(money >= totalMoneyRequired ? "0" : totalMoneyRequired - money);
    }
}
