package main.java.codingstudio.codingninja;

/*
Question: Shortest Word Distance II
Link: https://www.naukri.com/code360/problems/shortest-word-distance-ii_1459114
 */

public class ShortestWordDistance2 {
    public static void main(String[] args) {
        System.out.println(minimumDistance(new String[]{"coding", "ninjas", "help", "to", "crack", "product", "based", "companies"}, "coding", "product"));
        System.out.println(minimumDistance(new String[]{"eat", "code", "sleep", "repeat", "eat", "code", "sleep", "repeat"}, "eat", "repeat"));
    }

    public static int minimumDistance(String[] arr, String book1, String book2) {
        // Write your code here
        int a = -1, b = -1, diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(book1)) {
                a = i;
            } else if (arr[i].equals(book2)) {
                b = i;
            }

            if (a != -1 && b != -1) {
                diff = Math.min(Math.abs(a - b), diff);
            }
        }

        return diff;
    }
}
