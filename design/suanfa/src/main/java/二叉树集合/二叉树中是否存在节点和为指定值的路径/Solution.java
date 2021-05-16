package 二叉树集合.二叉树中是否存在节点和为指定值的路径;

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
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return check(root, sum, 0);
    }

    private boolean check(TreeNode root, int sum, int currSum) {
        if (root == null) {
            return false;
        }
        currSum += root.val;
        return check(root.left, sum, currSum) || check(root.right, sum, currSum);
    }
}
