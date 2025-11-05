package main.java.other;

import main.java.common.TreeNode;

public class SumTree {

    static class Result{
	    int sum;
	    boolean isSumTree;

		public Result(int sum, boolean isSumTree) {
			this.sum = sum;
			this.isSumTree = isSumTree;
		}

		@Override
		public String toString() {
			return "Result{" +
					"sum=" + sum +
					", isSumTree=" + isSumTree +
					'}';
		}
	}
	private Result dfs(TreeNode node) {
	    if(node ==null) {
	        return new Result(0, true);
	    }
	    if(node.left==null && node.right==null) {
	        return new Result(node.val, true);
	    }

	    Result left = dfs(node.left);
	    Result right = dfs(node.right);
	    boolean isSumTree = left.isSumTree && right.isSumTree && (node.val == right.sum+ left.sum);
	    return new Result(node.val + right.sum + left.sum, isSumTree);
	}

    public static void main(String[] args) {
		var sumTree = new SumTree();
		TreeNode root = new TreeNode(26);
		root.left = new TreeNode(10);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(3);

		System.out.println(sumTree.dfs(root));

		root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		System.out.println(sumTree.dfs(root));
    }
}
