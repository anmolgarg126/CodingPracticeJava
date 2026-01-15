package main.java.leetcode;

import main.java.common.TreeNode;

/*
Question: 865. Smallest Subtree with all the Deepest Nodes
Link: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class SmallestSubtreeWithAllTheDeepestNodes_865 {
    public static void main(String[] args) {
        var obj = new SmallestSubtreeWithAllTheDeepestNodes_865();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(0);
        root.right.right.right = new TreeNode(8);
        System.out.println(obj.subtreeWithAllDeepest(root).val);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(null, 0);
        }

        Result left = dfs(node.left);
        Result right = dfs(node.right);
        if (left.d > right.d) {
            return new Result(left.node, left.d + 1);
        }
        if (right.d > left.d) {
            return new Result(right.node, right.d + 1);
        }
        return new Result(node, left.d + 1);
    }

    record Result(TreeNode node, int d) {
    }
}
