package main.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/*
Question: 1352. Product of the Last K Numbers
Link: https://leetcode.com/problems/product-of-the-last-k-numbers
 */
public class ProductOfTheLastKNumbers_1352 {
    private List<Integer> prefixProduct;

    public static void main(String[] args) {
        var obj = new ProductOfTheLastKNumbers_1352();
        obj.testcase1();
    }

    private void testcase1() {
        String[] input = {"add", "add", "add", "add", "add", "getProduct", "getProduct", "getProduct", "add", "getProduct"};
        int[] intInput = {3, 0, 2, 5, 4, 2, 3, 4, 8, 2};

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("add")) {
                add(intInput[i]);
            } else if (input[i].equals("getProduct")) {
                System.out.println(getProduct(intInput[i]));
            }

        }
    }

    public ProductOfTheLastKNumbers_1352() {
        prefixProduct = new LinkedList<>();
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct = new LinkedList<>();
        } else if (!prefixProduct.isEmpty()) {
            int product = prefixProduct.get(prefixProduct.size() - 1) * num;
            prefixProduct.add(product);
        } else {
            prefixProduct.add(num);
        }
    }

    public int getProduct(int k) {
        if (prefixProduct.size() < k) {
            return 0;
        } else if (prefixProduct.size() == k) {
            return prefixProduct.get(prefixProduct.size() - 1);
        } else {
            int max = prefixProduct.get(prefixProduct.size() - 1);
            int min = prefixProduct.get(prefixProduct.size() - k - 1);

            return max / min;
        }
    }
}
