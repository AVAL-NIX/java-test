package 二叉搜索树中的搜索;

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
    public TreeNode searchBST(TreeNode root, int val) {
        BST(root, val);
        return res;
    }

    public TreeNode res;

    private void BST(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            res = root;
            return;
        }
        if (root.val > val) {
            BST(root.left, val);
        }
        if (root.val < val) {
            BST(root.right, val);
        }
    }
}
