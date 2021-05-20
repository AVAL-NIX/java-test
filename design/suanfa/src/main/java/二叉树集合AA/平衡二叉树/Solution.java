package 二叉树集合AA.平衡二叉树;

import common.TreeNode;

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDeep = getDeep(root.left);
        int rightDeep = getDeep(root.right);
        //每颗都是绝对值差1
        return Math.abs(leftDeep - rightDeep) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    /**
     * 求树高， ，
     *
     * @param root
     * @return
     */
    private int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDeep(root.left), getDeep(root.right)) + 1;
    }
}
