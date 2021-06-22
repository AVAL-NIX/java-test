package 二叉树集合AA.二叉搜索树的第k大节点;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        bst(root);
        return res;
    }

    int k = 0;
    int res =0 ;

    public void bst(TreeNode root){
        if(root == null){
            return ;
        }
        bst(root.right);
        k--;
        if(k==0){
            res = root.val;
            return ;
        }
        bst(root.left);
      
    }
}