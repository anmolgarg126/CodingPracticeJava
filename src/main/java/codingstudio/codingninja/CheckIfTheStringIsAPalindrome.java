package main.java.codingstudio.codingninja;

/*
Question: Check If The String Is A Palindrome
Link: https://www.naukri.com/code360/problems/check-if-the-string-is-a-palindrome_1062633
 */
public class CheckIfTheStringIsAPalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("c1 O$d@eeD o1c"));
        System.out.println(checkPalindrome("N2 i&nJA?a& jnI2n"));
        System.out.println(checkPalindrome("A1b22Ba"));
    }

    public static boolean checkPalindrome(String str) {

        // WRITE YOUR CODE HERE
        int l = 0, r = str.length() - 1;
        while (l < r) {
            char lc = str.charAt(l);
            char rc = str.charAt(r);
            if (!Character.isAlphabetic(lc) && !Character.isDigit(lc)) {
                l++;
            } else if (!Character.isAlphabetic(rc) && !Character.isDigit(rc)) {
                r--;
            } else if (Character.toLowerCase(lc) == Character.toLowerCase(rc)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

}
