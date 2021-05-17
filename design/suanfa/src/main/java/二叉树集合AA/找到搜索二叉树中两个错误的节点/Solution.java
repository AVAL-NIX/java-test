package 二叉树集合AA.找到搜索二叉树中两个错误的节点;


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

    public int[] findError(TreeNode root) {
        // write code here
        //中序得到结果
        midTraverse(root);
        //对数组进行检查 , 从左往右找大值 ， 从右往左找小值
        int i, j;
        for (i = 0; i < list.size() - 1; i++) {
            int pre = list.get(i);
            int after = list.get(i + 1);
            if (pre > after) {
                error[1] = pre;
                break;
            }
        }
        //找小值
        for (j = list.size() - 1; j > i; j--) {
            int pre = list.get(j - 1);
            int after = list.get(j);
            if (pre > after) {
                error[0] = after;
                break;
            }
        }
        return error;
    }

    public int[] error = new int[2];
    public List<Integer> list = new ArrayList<>();

    private void midTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        midTraverse(root.left);
        list.add(root.val);
        midTraverse(root.right);
    }

}
