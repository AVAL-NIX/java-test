package 二叉树的之字形层序遍历;

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
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // base case
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            //do
            ArrayList<Integer> str = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                str.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            if (str.size() > 0) {
                result.add(str);
            }
            // 偶数层
            ArrayList<Integer> str2 = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                str2.add(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }

            }
            if (str2.size() > 0) {
                result.add(str2);
            }

        }
        return result;
    }
}
