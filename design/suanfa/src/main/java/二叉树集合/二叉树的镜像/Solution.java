package 二叉树集合.二叉树的镜像;

import common.TreeNode;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    public TreeNode Mirror (TreeNode pRoot) {
        return revers(pRoot);
    }

    public TreeNode revers(TreeNode root){
        if(root == null){
            return null ;
        }

        root.left = revers(root.left);
        root.right = revers(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
