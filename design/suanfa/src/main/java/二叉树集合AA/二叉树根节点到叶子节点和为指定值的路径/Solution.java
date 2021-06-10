package 二叉树集合AA.二叉树根节点到叶子节点和为指定值的路径;

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
     * 
     * @param root TreeNode类 
     * @param sum int整型 
     * @return int整型ArrayList<ArrayList<>>
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
           dfs(root,temp, sum);
        
        return res;
    }
    
    public void dfs(TreeNode root,ArrayList<Integer> temp, int sum){
        if(root == null){
            return ;
        }
       
        sum -= root.val;
        temp.add(root.val);
        if(sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<Integer>(temp));
            return ;
        }
        dfs(root.left, new ArrayList<Integer>(temp) , sum);
        dfs(root.right,new ArrayList<Integer>(temp) , sum);
    }
}