package 二叉树集合AA.二叉树的最大深度;

import common.TreeNode;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        return traverse(root);
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + traverse(root.left), 1 + traverse(root.right));
    }
}
