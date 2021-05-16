package 二叉树集合.在二叉树中找到两个节点的最近公共祖先;

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
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        return tranverse(root, o1, o2).val;
    }

    private TreeNode tranverse(TreeNode root, int o1, int o2) {
        if (root == null || o1 == root.val || o2 == root.val) {
            return root;
        }

        TreeNode left = tranverse(root.left, o1, o2);
        TreeNode right = tranverse(root.right, o1, o2);
        //后序遍历位置
        //如果左边不在 就在右边
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
