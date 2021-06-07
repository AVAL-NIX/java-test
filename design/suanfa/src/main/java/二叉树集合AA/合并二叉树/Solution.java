package 二叉树集合AA.合并二叉树;

/*
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

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
