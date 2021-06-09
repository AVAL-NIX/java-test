package 二叉树集合AA.二叉树的后序遍历;

import common.TreeNode;

import java.util.*;

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
    public List<Integer> postorderTraversal2(TreeNode root) {
        back(root);
        return res;
    }

    public void back(TreeNode root) {
        if (root == null) {
            return;
        }
        back(root.left);
        back(root.right);
        res.add(root.val);
    }

    List<Integer> res = new ArrayList<>();


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res2 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return res2;
        }
        TreeNode flag = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                //都是先拿
                root = stack.pop();
                //判断有没有右孩子， 如果有右孩子， 记得入栈
//                * 这块就是判断treeNode是否有右孩子，
//                 * 如果没有输出treeNode.data，让lastVisit指向treeNode，并让treeNode为空
//                 * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
//                treeNode.right == null  是右孩子的判断条件， 或者根节点没有右孩子节点。
//                如果根节点有右孩子节点 。 treeNode.right == flag 这个条件可以跳出循环
                if (root.right == null || root.right == flag) {
                    res2.add(root.val);
                    // 这里是用来标记避免重复循环的 ， 避免右孩子的根节点重复 右-根-右-根
                    flag = root;
                    // 打印过就跳出。
                    root = null;
                } else {
                    // 如果有右孩子，根孩子重新入栈
                    stack.add(root);
                    // treeNode.left 已经打印过了。 遍历右孩子
                    root = root.right;
                }

            }
        }
        return res;
    }


}