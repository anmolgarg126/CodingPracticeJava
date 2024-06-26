package main.java.leetcode;

/*
Question: 995. Minimum Number of K Consecutive Bit Flips
Link: https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips
 */
public class MinimumNumberOfKConsecutiveBitFlips_995 {
    public static void main(String[] args) {
        var obj = new MinimumNumberOfKConsecutiveBitFlips_995();
        System.out.println(obj.minKBitFlips(new int[]{0, 1, 0}, 1));
        System.out.println(obj.minKBitFlips(new int[]{1, 1, 0}, 2));
        System.out.println(obj.minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
    }

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                int tempK = k - 1;
                if (i + tempK < n) {
                    while (tempK > 0) {
                        nums[i + tempK] = nums[i + tempK] == 1 ? 0 : 1;
                        tempK--;
                    }
                }else {
                    return -1;
                }
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }
        return count;
    }
}
