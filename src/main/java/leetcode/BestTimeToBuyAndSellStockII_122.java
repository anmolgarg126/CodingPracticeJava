package main.java.leetcode;

/*
Question: 122. Best Time to Buy and Sell Stock II
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII_122 {
    public static void main(String[] args) {
        var obj = new BestTimeToBuyAndSellStockII_122();
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(obj.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(obj.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                maxProfit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}
