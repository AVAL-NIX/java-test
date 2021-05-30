package 二叉树集合AA.判断一棵二叉树是否为搜索二叉树和完全二叉树;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt(TreeNode root) {
        boolean isSearch = isSearchFn(root, null, null);
        boolean isWanquan = isEndFn(root);
        return new boolean[]{isSearch, isWanquan};
    }

    private boolean isEndFn(TreeNode node) {
        if (node == null) {
            return true;
        }
        Deque<TreeNode> deque = new ArrayDeque();
        deque.push(node);
        while (deque.peek() != null) {
            TreeNode temp = deque.poll();
            deque.add(temp.left);
            deque.add(temp.right);
        }
        while (deque.isEmpty() && deque.peek() == null) {
            deque.poll();
        }
        return deque.isEmpty();
    }



    private boolean isSearchFn(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && min >= node.val) {
            return false;
        }
        if (max != null && max <= node.val) {
            return false;
        }
        return isSearchFn(node.left, min, node.val) && isSearchFn(node.right, node.val, max);
    }
}