package 二叉搜索树中第K小的元素;

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
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public int rank = 0;
    public int res = 0;

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        //进行操作
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }
}
