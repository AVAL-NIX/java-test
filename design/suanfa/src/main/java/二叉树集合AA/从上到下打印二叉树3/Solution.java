package 二叉树集合AA.从上到下打印二叉树3;

import common.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> single = new Stack<>();
        Stack<TreeNode> double2 = new Stack();
        single.add(root);
        while (!single.isEmpty() || !double2.isEmpty()) {
            int len = single.size();
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode temp = single.pop();
                if (temp.left != null) {
                    double2.add(temp.left);
                }
                if (temp.right != null) {
                    double2.add(temp.right);
                }
                t.add(temp.val);
            }
            if (t.size() > 0)
                res.add(t);
            t = new ArrayList<>();
            //双
            int len2 = double2.size();
            for (int i = 0; i < len2; i++) {
                TreeNode temp = double2.pop();
                if (temp.right != null) {
                    single.add(temp.right);
                }
                if (temp.left != null) {
                    single.add(temp.left);
                }
                t.add(temp.val);
            }
            if (t.size() > 0)
                res.add(t);
        }
        return res;
    }
}