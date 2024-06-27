package main.java.codingstudio.codingninja;

/*
Question: GCD or HCF
Link: https://www.naukri.com/code360/problems/gcd-or-hcf_10870939
 */
public class GCDOrHCF {
    public static void main(String[] args) {
        System.out.println(calcGCD(9, 6));
        System.out.println(calcGCD(2, 5));
    }

    public static int calcGCD(int n, int m) {
        // Write your code here.
        if (n == 0) {
            return m;
        }
        if (n < m) {
            return calcGCD(m % n, n);
        } else {
            return calcGCD(n % m, m);
        }
    }
}
