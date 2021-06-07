package 二叉树集合AA.将有序数组转换为二叉搜索树;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return null;
        }
        return dfs(nums, 0 , nums.length);
    }
    int index = 0;

    public TreeNode dfs(int[] nums, int left , int right){
        if(left > right){
            return null;
        }
        int mid = (left + right )/ 2;
        TreeNode head = new TreeNode(mid);
        head.left = dfs(nums , left ,mid-1);
        head.right = dfs(nums , mid+1, right);
        return head;
    }
}