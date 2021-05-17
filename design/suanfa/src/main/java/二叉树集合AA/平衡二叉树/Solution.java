package 二叉树集合AA.平衡二叉树;

import common.TreeNode;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return traverse(root, null, null);
    }

    private boolean traverse(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        return traverse(root.left, min, root) &&
                traverse(root.right, root, max);
    }
}
