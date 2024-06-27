package main.java.codingstudio.codingninja;

/*
Question:  Check Prime
Link: https://www.naukri.com/code360/problems/check-prime_624934
 */
public class CheckPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(5));
        System.out.println(isPrime2(5));
    }

    public static String isPrime(int n) {
        //Your code goes here
        if (n < 2) {
            return "NO";
        }

        int i = 2, m = (int) Math.sqrt(n);
        while (i <= m) {
            if (n % i == 0) {
                return "NO";
            }
            i++;
        }

        return "YES";
    }

    public static String isPrime2(int n) {
        //Your code goes here
        if (n < 2) {
            return "NO";
        }
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        return prime[n] ? "YES" : "NO";
    }
}
