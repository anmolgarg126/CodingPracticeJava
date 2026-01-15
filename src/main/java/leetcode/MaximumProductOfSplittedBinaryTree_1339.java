package main.java.leetcode;

import main.java.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Question: 1339. Maximum Product of Splitted Binary Tree
Link: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 */
public class MaximumProductOfSplittedBinaryTree_1339 {
    private int mod = 1000000007;

    public static void main(String[] args) {
        var obj = new MaximumProductOfSplittedBinaryTree_1339();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(obj.maxProduct(root));
    }

    public int maxProduct(TreeNode root) {
        long total = dfs(root);
        long max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            long curr = (total - node.val) * node.val;
            max = Math.max(max, curr);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return (int) (max % mod);
    }

    private long dfs(TreeNode node) {
        if (node == null) return 0;
        node.val += dfs(node.left) + dfs(node.right);
        return node.val;
    }
}
