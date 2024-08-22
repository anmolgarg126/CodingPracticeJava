package main.java.leetcode;

import java.util.*;

/*
Question: 2191. Sort the Jumbled Numbers
Link: https://leetcode.com/problems/sort-the-jumbled-numbers
 */
public class SortTheJumbledNumbers_2191 {
    public static void main(String[] args) {
        var obj = new SortTheJumbledNumbers_2191();
        System.out.println(Arrays.toString(obj.sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38})));
        System.out.println(Arrays.toString(obj.sortJumbled(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{789, 456, 123})));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int mappedValue = getMappedValue(mapping, num);
            if (map.containsKey(mappedValue)) {
                map.get(mappedValue).add(num);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(num);
                map.put(mappedValue, list);
            }
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        int[] result = new int[nums.length];

        int index = 0;
        for (int key : keyList) {
            List<Integer> list = map.get(key);
            for (Integer integer : list) {
                result[index++] = integer;
            }
        }

        return result;
    }

    private int getMappedValue(int[] mapping, int num) {
        String input = Integer.toString(num);
        int res = 0;
        for (int i = 0; i < input.length(); i++) {
            res = (res * 10) + mapping[input.charAt(i) - '0'];
        }
        return res;
    }
}
