package 二叉树集合.二叉树的最大路径和;

import common.TreeNode;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * TODO
     * @param root TreeNode类
     * @return int整型
     */
    public int maxPathSum(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        sum = root.val;
        traverse(root.left);
        traverse(root.right);
        return sum;
    }

    public int sum = 0;

    private void traverse(TreeNode root) {
        if (root == null || root.val + sum <= sum) {
            return;
        }
        sum += root.val;
        traverse(root.left);
        traverse(root.right);
    }
}
