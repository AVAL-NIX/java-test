package 动态规划AA.打家劫舍3;

import common.TreeNode;

import java.util.HashMap;

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
    public int rob(TreeNode root) {
        return  dp(root);
    }

    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int dp(TreeNode node) {
        //base case
        if (node == null) {
            return 0;
        }
        if (memo.containsKey(node)) {
            return memo.get(node);
        }
        // 抢 。
        int do_it = node.val;
        int do_it_l = node.left == null ? 0 : dp(node.left.left) + dp(node.left.right);
        int do_it_r = node.right == null ? 0 : dp(node.right.left) + dp(node.right.right);

        // 不抢，然后去下家
        int not_do = dp(node.left) + rob(node.right);
        int res = Math.max(not_do, do_it + do_it_l + do_it_r);
        memo.put(node, res);
        return res;
    }
}