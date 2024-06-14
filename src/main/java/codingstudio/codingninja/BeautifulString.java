package main.java.codingstudio.codingninja;

/*
Question: Beautiful String
Link: https://www.naukri.com/code360/problems/beautiful-string_1115625
 */

// TODO:: Not working
public class BeautifulString {
    public static void main(String[] args) {
        System.out.println(makeBeautiful("01010010101"));
        System.out.println(makeBeautiful("01011"));
        System.out.println(makeBeautiful("1001"));
        System.out.println(makeBeautiful("0000"));
        System.out.println(makeBeautiful("0101"));
        System.out.println(makeBeautiful("1010"));
        System.out.println(makeBeautiful("101010000010110100"));
        System.out.println(makeBeautiful("000001"));
        System.out.println(makeBeautiful("10111"));
        System.out.println(makeBeautiful("110100000101"));
    }

    public static int makeBeautiful(String str) {
        System.out.println(str);
        int res = 0;
        char[] chars = new char[]{str.charAt(0), str.charAt(0) == '0' ? '1' : '0'};

        for (int i = 1; i < str.length(); i++) {
            if(chars[i%2] != str.charAt(i)){
                res++;
            }
        }
        return res;
    }

}
