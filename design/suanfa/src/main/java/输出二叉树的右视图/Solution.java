package 输出二叉树的右视图;

import java.util.*;

/**
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图示例1
 *
 * @author zhengxin
 * @date 2021/4/8
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        List<Integer> result = new ArrayList<>();
        TreeNode tree = reBuild(xianxu);
        while (tree != null) {
            result.add(tree.val);
            if (tree.right != null) {
                tree = tree.right;
            } else {
                tree = tree.left;
            }
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    private TreeNode reBuild(int[] xianxu) {

        return null;
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
