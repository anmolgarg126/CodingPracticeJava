package main.java.leetcode;

/*
Question: 3147. Taking Maximum Energy From the Mystic Dungeon
Link: https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/
 */
public class TakingMaximumEnergyFromTheMysticDungeon_3147 {
    public static void main(String[] args) {
        var obj = new TakingMaximumEnergyFromTheMysticDungeon_3147();
        System.out.println(obj.maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));
        System.out.println(obj.maximumEnergy(new int[]{-2,-3,-1}, 2));
    }

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int result = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i];
            if (i + k < n) {
                dp[i] += dp[i + k];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
