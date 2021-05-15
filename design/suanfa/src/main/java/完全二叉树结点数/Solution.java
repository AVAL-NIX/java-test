package 完全二叉树结点数;

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
        int leftDeep = compileDeep(head.left);
        int rightDeep = compileDeep(head.right);
        if (leftDeep == rightDeep) {
            return 2^(leftDeep-1)-1;
        } else {
            //要计算左边边的深度
            return compileCount(head.left) + rightDeep;
        }
    }

    private int compileDeep(TreeNode head) {
        int deep = 0;
        while (head != null) {
            head = head.left;
            deep += 1;
        }
        return deep;
    }


    private int compileCount(TreeNode head) {
        int deep = 0;
        while (head != null) {
            head = head.left;
            deep += 1;
        }
        return deep;
    }
}
