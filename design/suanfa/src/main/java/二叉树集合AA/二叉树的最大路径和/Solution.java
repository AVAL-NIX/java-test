package 二叉树集合AA.二叉树的最大路径和;

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
     * @return int整型
     */
    public int maxPathSum (TreeNode root) {
        if(root == null){
            return max;
        }
        track(root);
        return max;
    }

    private int track(TreeNode root) {
        // base
        if(root == null){
            return 0;
        }
        //计算 左右2边的最大值
        int leftMax = Math.max(track(root.left), 0);
        int rightMax = Math.max(track(root.right), 0);
        // 根值 +  左最大 + 右最大， 构成最大路径和， 跟MAX比较谁大
        int rootSum = root.val + leftMax + rightMax;
        max = Math.max(max, rootSum);
        //返回节点最大值
        //根的值+ 左边 或者右边最大的值 就是这个节点的最大值
        return root.val + Math.max(leftMax,rightMax);
    }

    int max = Integer.MIN_VALUE;
}