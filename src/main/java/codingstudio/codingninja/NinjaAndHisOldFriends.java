package main.java.codingstudio.codingninja;

import java.util.ArrayList;
import java.util.Arrays;

/*
Question:  Ninja And His Old Friends
Link: https://www.naukri.com/code360/problems/ninja-and-his-old-friends_1214934
 */
public class NinjaAndHisOldFriends {
    public static void main(String[] args) {
        System.out.println(shakeHands(new ArrayList<>(Arrays.asList(1, 2, 4)), 3, 1));
        System.out.println(shakeHands(new ArrayList<>(Arrays.asList(1, 2)), 2, 4));
    }

    public static int shakeHands(ArrayList<Integer> friends, int n, int k) {
        // Write your code here.

        for (int i : friends) {
            if (i == k) {
                k *= 2;
            }
        }
        return k;
    }
}

