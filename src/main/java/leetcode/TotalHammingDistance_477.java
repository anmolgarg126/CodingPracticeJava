package main.java.leetcode;

/*
Question: 477. Total Hamming Distance
Link: https://leetcode.com/problems/total-hamming-distance

Logic:
For each bit position 1-32 in a 32-bit integer,
we count the number of integers in the array which have that bit set.
Then, if there are n integers in the array and k of them have a
particular bit set and (n-k) do not, then that bit
contributes k*(n-k) hamming distance to the total.
 */
public class TotalHammingDistance_477 {
    public static void main(String[] args) {
        var obj = new TotalHammingDistance_477();
        System.out.println(obj.totalHammingDistance(new int[]{4, 14, 2}));
        System.out.println(obj.totalHammingDistance(new int[]{4, 14, 4}));
    }

    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < n; j++) {
                bitCount += (nums[j] >> i) & 1;
            }
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}
