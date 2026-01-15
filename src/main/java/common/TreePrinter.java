package main.java.common;

import java.util.*;

public class TreePrinter {

    public static void printVertical(TreeNode root) {
        if (root == null) {
            System.out.println("(empty)");
            return;
        }

        int h = height(root);

        Queue<TreeNode> q = new LinkedList<>(); // ✅ allows nulls
        q.add(root);

        for (int level = 1; level <= h; level++) {
            int levelSize = q.size();

            int indent = (1 << (h - level + 1)) - 1;
            int between = (1 << (h - level + 2)) - 1;

            printSpaces(indent);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();

                if (node == null) {
                    System.out.print(" ");
                    q.add(null);
                    q.add(null);
                } else {
                    System.out.print(node.val);
                    q.add(node.left);   // may be null -> OK in LinkedList
                    q.add(node.right);  // may be null -> OK in LinkedList
                }

                if (i != levelSize - 1) printSpaces(between);
            }
            System.out.println();

            if (allNulls(q)) break;
        }
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) System.out.print(" ");
    }

    private static boolean allNulls(Queue<TreeNode> q) {
        for (TreeNode n : q) {
            if (n != null) return false;
        }
        return true;
    }
}
