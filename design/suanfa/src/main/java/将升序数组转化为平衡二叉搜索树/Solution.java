package 将升序数组转化为平衡二叉搜索树;

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
     * @param num int整型一维数组
     * @return TreeNode类
     */
    public TreeNode sortedArrayToBST(int[] num) {
        // write code here
        return BST(num, 0, num.length - 1);
    }

    private TreeNode BST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);

        root.left = BST(num, start, mid - 1);
        //中序进程操作

        root.right = BST(num, mid + 1, end);
        return root;
    }
}
