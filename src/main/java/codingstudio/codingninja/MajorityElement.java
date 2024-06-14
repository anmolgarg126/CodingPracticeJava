package main.java.codingstudio.codingninja;

/*
Question: Majority element
Link: https://www.naukri.com/code360/problems/majority-element_842495
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(findMajority(new int[]{20, 20, 20, 4, 5, 20, 1, 20, 4, 20}, 10));
    }

    public static int findMajority(int[] arr, int n) {
        // Write your code here.
        int count = 1, element = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] == element) {
                count++;
            } else {
                if (count == 0) {
                    element = arr[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for (int i : arr) {
            if (i == element) {
                count++;
            }
        }

        return count > (n / 2) ? element : -1;
    }
}
