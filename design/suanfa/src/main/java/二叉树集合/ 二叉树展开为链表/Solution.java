package 二叉树展开为链表;

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

    public void flatten(TreeNode root) {
        //用后序
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //1. 拼接
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 2 连接
        root.left = null;
        root.right = left;
        // 3.将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        //找到最尾巴的right
        while (p.right != null) {
            p = p.right;
        }
        //接入
        p.right = right;
    }
}
