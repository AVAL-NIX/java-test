package 二叉树集合AA.二叉树搜索树的最近公共祖先;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = root;
        while(true){
            if( p.val > a.val && q.val > a.val){
                a = a.right;
            }else if(p.val < a.val && q.val < a.val){
                a = a.left;
            }else{
                break;
            }
        }
        return a;
    }
}