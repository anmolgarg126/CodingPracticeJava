package main.java.leetcode;

/*
Question: 121. Best Time to Buy and Sell Stock
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        var obj = new BestTimeToBuyAndSellStock_121();
        System.out.println(obj.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(obj.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                profit = Math.max(prices[i] - buy, profit);
            }
        }
        return profit;
    }
}
