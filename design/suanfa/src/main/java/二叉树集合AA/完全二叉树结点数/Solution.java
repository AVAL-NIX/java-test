package 二叉树集合AA.完全二叉树结点数;

import common.TreeNode;

/**
 * public class TreeNode {
 * int val = 0;
 * TreeNode left = null;
 * TreeNode right = null;
 * <p>
 * public TreeNode(int val) {
 * this.val = val;
 * <p>
 * }
 * }
 */
public class Solution {
    public int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
       return countNodes(head);
    }

    private int compileDeep(TreeNode head) {
        int deep = 0;
        while (head != null) {
            head = head.left;
            deep += 1;
        }
        return deep;
    }
    private int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }



}
