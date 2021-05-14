package 合并二叉树;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // write code here
        return sumTrees(t1, t2);
    }

    private TreeNode sumTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode root = t1 == null ? t2 : t1;
        int rootVal = 0;
        if (t1 != null) {
            rootVal += t1.val;
        }
        if (t2 != null) {
            rootVal += t2.val;
        }
        root.val = rootVal;
        root.left = sumTrees(t1 != null && t1.left != null ? t1.left : null, t2 != null && t2.left != null ? t2.left : null);
        root.right = sumTrees(t1 != null && t1.right != null ? t1.right : null, t2 != null && t2.right != null ? t2.right : null);
        return root;
    }


    public class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;
    }
}
