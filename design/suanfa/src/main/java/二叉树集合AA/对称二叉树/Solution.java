package 二叉树集合AA.对称二叉树;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }


    private boolean check2(TreeNode left, TreeNode right) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(left);
        deque.push(right);
        while (!deque.isEmpty()) {
            TreeNode leftV = deque.poll();
            TreeNode rightV = deque.poll();
            if (leftV == null && rightV == null) {
                continue;
            }
            if (leftV == null && rightV != null) {
                return false;
            }
            if (leftV != null && rightV == null) {
                return false;
            }
            if (leftV.val != rightV.val) {
                return false;
            }

            deque.push(leftV.left);
            deque.push(rightV.right);

            deque.push(leftV.right);
            deque.push(rightV.left);
        }
        return true;
    }


}