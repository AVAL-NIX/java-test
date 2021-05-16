package 二叉树集合.把二叉搜索树转换为累加树;

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
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    public int sum = 0;

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        //中序
        sum += root.val;

        root.val = sum;

        traverse(root.left);
    }
}
