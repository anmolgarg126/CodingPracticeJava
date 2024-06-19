package main.java.leetcode;

/*
Question: 1482. Minimum Number of Days to Make m Bouquets
Link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 */
public class MinimumNumberOfDaysToMakeMBouquets_1482 {
    public static void main(String[] args) {
        var obj = new MinimumNumberOfDaysToMakeMBouquets_1482();
        System.out.println(obj.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(obj.minDays(new int[]{1, 10, 3, 10, 2}, 3, 12));
        System.out.println(obj.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        System.out.println(obj.minDays(new int[]{1000000000, 1000000000}, 1, 1));
    }


    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k) {
            return -1;
        }

        int minDays = Integer.MAX_VALUE, maxDays = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            if (day > maxDays) {
                maxDays = day;
            }
            if (day < minDays) {
                minDays = day;
            }
        }

        int mid;
        int res = -1;
        while (minDays <= maxDays) {
            mid = ((maxDays - minDays) / 2) + minDays;
            int possibleBouquets = totalPossibleBouquets(bloomDay, k, mid);
            if (possibleBouquets == m || possibleBouquets > m) {
                res = mid;
                maxDays = mid - 1;
            } else {
                minDays = mid + 1;
            }
        }
        return res;
    }

    private int totalPossibleBouquets(int[] bloomDay, int k, int day) {
        int result = 0;
        int index = 0, curr = 0;

        while (index < bloomDay.length) {
            if (bloomDay[index] <= day) {
                curr++;
            } else {
                curr = 0;
            }
            if (curr == k) {
                result++;
                curr = 0;
            }
            index++;
        }
        return result;
    }
}
