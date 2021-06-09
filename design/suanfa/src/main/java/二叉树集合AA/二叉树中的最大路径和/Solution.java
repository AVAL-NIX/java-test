package 二叉树集合AA.二叉树中的最大路径和;


import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return max;
        }
        tack(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    public int tack(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = Math.max(tack(root.left), 0);
        int rightValue = Math.max(tack(root.right), 0);


        max = Math.max(max, root.val + leftValue + rightValue);
        return root.val + Math.max(leftValue, rightValue);
    }
}