package 二叉树集合AA.树的子结构;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if( A == null || B == null){
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left ,B ) || isSubStructure(A.right, B);
    }
    public boolean dfs(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null || A.val != B.val){
            return false;
        }
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}