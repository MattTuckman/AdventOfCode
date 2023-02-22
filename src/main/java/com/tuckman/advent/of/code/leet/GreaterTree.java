package com.tuckman.advent.of.code.leet;

/**
 * Passed. Originally tried to return the sums, but it's way simpler to return left sum + right sum + self.
 * This avoids any issues with double counting.
 */
public class GreaterTree {

    public TreeNode bstToGst(TreeNode root) {
        help(root, 0);
        return root;
    }

    public int help(TreeNode curr, int greaterSum) {
        if (curr == null) {
            return 0;
        }

        int rightSum = help(curr.right, greaterSum);
        int greaterOrEqVals = curr.val + rightSum + greaterSum;
        int leftSum = help(curr.left, greaterOrEqVals);

        int temp = curr.val;
        curr.val = curr.val + rightSum + greaterSum;

        return temp + leftSum + rightSum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
