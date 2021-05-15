package 二叉树集合.完全二叉树结点数;

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
            // 这里不太明白 TODO
            return (int)Math.pow(2, leftDeep)  + nodeNum(head.right);
        } else {
            //要计算左边边的深度
            return (int) Math.pow(2, rightDeep) + nodeNum(head.left);
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

}
