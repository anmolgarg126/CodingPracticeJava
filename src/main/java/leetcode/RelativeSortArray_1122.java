package main.java.leetcode;

import java.util.*;

public class RelativeSortArray_1122 {

    public static void main(String[] args) {
        var obj = new RelativeSortArray_1122();
        obj.executeTestCase1();
        obj.executeTestCase2();
    }


    private void executeTestCase1() {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    private void executeTestCase2() {
        int[] arr1 = new int[]{28, 6, 22, 8, 44, 17};
        int[] arr2 = new int[]{22, 28, 8, 6};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    private int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr1) {
            map.merge(i, 1, Integer::sum);
        }

        int index = 0;
        for (int i : arr2) {
            int freq = map.getOrDefault(i, 0);
            while (freq-- > 0) {
                arr1[index++] = i;
            }
            map.remove(i);
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            Integer key = entry.getKey();
            while (freq-- > 0) {
                pq.add(key);
            }
        }

        while (!pq.isEmpty()) {
            arr1[index++] = pq.poll();
        }
        return arr1;
    }

    /**
     * This will work as max int value is 1000, and we need not to sort the remaining array
     */
    private int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int i : arr1) {
            cnt[i]++;
        }
        int[] ans = new int[arr1.length];
        int i = 0;
        for (int n : arr2) {
            while (cnt[n] > 0) {
                ans[i] = n;
                cnt[n]--;
                i++;
            }
        }
        for (int j = 0; j < cnt.length; j++) {
            while (cnt[j] > 0) {
                ans[i] = j;
                cnt[j]--;
                i++;
            }
        }
        return ans;
    }

}
