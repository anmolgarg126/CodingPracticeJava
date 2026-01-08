package main.java.leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
Question: 1475. Final Prices With a Special Discount in a Shop
Link: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */
public class FinalPricesWithASpecialDiscountInAShop_1475 {
    public static void main(String[] args) {
        var obj = new FinalPricesWithASpecialDiscountInAShop_1475();
        System.out.println(Arrays.toString(obj.finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(obj.finalPrices(new int[]{10,1,1,6})));
        System.out.println(Arrays.toString(obj.finalPrices(new int[]{8, 7, 4, 2, 8, 1, 7, 7, 10, 1})));
    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] res = prices.clone();

        for (int i = 0; i < res.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                res[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return res;
    }
}
