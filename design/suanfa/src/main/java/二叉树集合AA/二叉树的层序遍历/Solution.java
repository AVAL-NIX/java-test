package 二叉树集合AA.二叉树的层序遍历;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

/**
 * BFS
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len  =deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode r = deque.pop();
                if (r.left != null) {
                    deque.push(r.left);
                }
                if (r.right != null) {
                    deque.push(r.right);
                }
                temp.add(r.val);
            }
            res.add(temp);
        }
        return res;
    }
}