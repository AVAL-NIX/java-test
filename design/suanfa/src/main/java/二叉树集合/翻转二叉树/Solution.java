package 二叉树集合.翻转二叉树;

import common.TreeNode;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        /**** 前序遍历位置 ****/
        // root 节点需要交换它的左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
