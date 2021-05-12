package 二叉树的中序遍历;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal(TreeNode root) {
        midTree(root);
        return mid.stream().mapToInt(Integer::valueOf).toArray();
    }

    public List<Integer> mid = new ArrayList<Integer>();

    public void midTree(TreeNode root) {
        if (root == null) {
            return;
        }
        midTree(root.left);
        mid.add(root.val);
        midTree(root.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
