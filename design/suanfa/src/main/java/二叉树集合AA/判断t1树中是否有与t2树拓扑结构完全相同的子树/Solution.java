package 二叉树集合AA.判断t1树中是否有与t2树拓扑结构完全相同的子树;

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
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    public boolean isContains(TreeNode root1, TreeNode root2) {
        // write code here
        //对二叉树 ，进行前序或者后续遍历

        String root1Str = BST(root1);
        String root2Str =  BST(root2);
        return root1Str.indexOf(root2Str) > -1 ? true : false;

    }

    private String BST(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return BST(root.left) +"," + BST(root.right) +"," + root.val ;
    }

}
