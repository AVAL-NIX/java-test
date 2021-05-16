package 二叉树集合.判断二叉树是否对称;

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
     * @return bool布尔型
     */
    public boolean isSymmetric(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val && check(left.left ,right.left) && check(left.right , right.right);
    }


}
