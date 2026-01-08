package main.java.bytebyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Question: Candies
Link: https://bytebytego.com/exercises/coding-patterns/greedy/candies
 */
public class Candies {
    public static void main(String[] args) {
        var obj = new Candies();
        System.out.println(obj.candies(Arrays.asList(4, 3, 2, 4, 5, 1)));
    }


    public int candies(List<Integer> ratings) {
        int n = ratings.size();
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i=1;i<n; i++) {
            if(ratings.get(i)>ratings.get(i-1)) {
                candies[i] = candies[i-1]+1;
            }
        }

//        System.out.println(Arrays.toString(candies));

        for(int i=n-2;i>=0; i--) {
            if(ratings.get(i)>ratings.get(i+1)) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
//        System.out.println(Arrays.toString(candies));
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }
}
