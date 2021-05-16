package 二叉树集合.验证二叉搜索树;

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
    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);
    }

    private boolean validBST(TreeNode root, TreeNode min, TreeNode max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }


        return validBST(root.left, min, root) && validBST(root.right, root, max);
    }
}
