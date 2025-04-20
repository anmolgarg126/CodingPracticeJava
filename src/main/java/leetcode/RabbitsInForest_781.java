package main.java.leetcode;

/*
Question: 781. Rabbits in Forest
Link: https://leetcode.com/problems/rabbits-in-forest/description
 */

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest_781 {
    public static void main(String[] args) {
        var obj = new RabbitsInForest_781();
        System.out.println(obj.numRabbits(new int[]{1, 1, 2}));
        System.out.println(obj.numRabbits(new int[]{10, 10, 10}));
        System.out.println(obj.numRabbits(new int[]{2, 2, 2, 2}));
    }

    public int numRabbits(int[] answers) {

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            frequency.merge(answers[i], 1, Integer::sum);
        }

        int result = 0;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() % (entry.getKey() + 1) == 0) {
                result += entry.getValue();
            } else {
                result = result + ((entry.getValue() / (entry.getKey() + 1)) + 1) * (entry.getKey() + 1);
            }
        }

        return result;

    }
}
