package main.java.codingstudio.codingninja;

/*
Question: Find Unique
Link: https://www.naukri.com/code360/problems/find-unique_625159
 */
public class FindUnique {
    public static void main(String[] args) {
        System.out.println(findUnique(new int[]{2, 3, 1, 6, 3, 6, 2}));
        System.out.println(findUnique(new int[]{2, 4, 7, 2, 7}));
        System.out.println(findUnique(new int[]{1, 3, 1, 3, 6, 6, 7, 10, 7}));
    }

    public static int findUnique(int[] arr) {
        //Your code goes here
        int res = 0;
        for (int i : arr) {
            res ^= i;
        }
        return res;
    }
}
