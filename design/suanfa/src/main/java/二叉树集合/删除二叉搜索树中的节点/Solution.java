package 二叉树集合.删除二叉搜索树中的节点;

import common.TreeNode;

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
    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode newTree = deleteTree(root, key);
        return newTree;
    }

    private TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            //删除操作
            //第1种情况， 没有子节点
//        if (root.left == null && root.right == null){
//            return null;
//        }
            //情况 2：A 只有一个非空子节点，那么它要让这个孩子接替自己的位置。
//        if (root.left == null) return root.right;
//        if (root.right == null) return root.left;
            //情况 3：A 有两个子节点，麻烦了，为了不破坏 BST 的性质，
            // A 必须找到左子树中最大的那个节点， TODO 或者右子树中最小的那个节点来接替自己。
            // 我们以第二种方式讲解。
            // 找到右子树的最小节点
//            TreeNode minNode = getMin(root.right);
//            // 把 root 改成 minNode
//            root.val = minNode.val;
//            // 转而去删除 minNode
//            root.right = deleteNode(root.right, minNode.val);
            //处理情况 1， 2
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            //处理情况3 , 选择右边小的
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteTree(root.right, minNode.val);
        }
        if (root.val < key) {
            root.right = deleteTree(root.right, key);
        }
        if (root.val < key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode right) {
        //BST最左边就是最小的。
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }
}
