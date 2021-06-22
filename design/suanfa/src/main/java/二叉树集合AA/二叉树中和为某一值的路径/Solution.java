package 二叉树集合AA.二叉树中和为某一值的路径;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        deep(root, target, 0, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void deep(TreeNode root, int target, int sum, ArrayList<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        sum += root.val;
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        deep(root.left, target, sum, new ArrayList<Integer>(temp));
        deep(root.right, target, sum, new ArrayList<Integer>(temp));
    }
}