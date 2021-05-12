package 实现二叉树先序中序和后序遍历;

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
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        traverse(root);
        int[] preint = pre.stream().mapToInt(Integer::valueOf).toArray();
        int[] midint = mid.stream().mapToInt(Integer::valueOf).toArray();
        int[] afterint = after.stream().mapToInt(Integer::valueOf).toArray();
        return new int[][]{preint, midint, afterint};
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> mid = new ArrayList<>();
    List<Integer> after = new ArrayList<>();

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        pre.add(root.val);
        traverse(root.left);
        mid.add(root.val);
        traverse(root.right);
        after.add(root.val);
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


}
