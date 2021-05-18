package 二叉树集合AA.输出二叉树的右视图;

import sun.reflect.generics.tree.Tree;

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
        List<Integer> result = new ArrayList<>();
        TreeNode tree = reBuild(xianxu, zhongxu);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            //遍历一层
            int len = queue.size();
            TreeNode tempRoot = null;
            for (int i = 0; i < len; i++) {
                tempRoot = queue.poll();
                if(tempRoot.left!=null){
                    queue.add(tempRoot.left);
                }
                if(tempRoot.right !=null ){
                    queue.add(tempRoot.right);
                }
            }
            //只留最后一个。
            result.add(tempRoot.val);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private TreeNode reBuild(int[] xianxu, int[] zhongxu) {
        return build(xianxu, zhongxu, 0, xianxu.length - 1, 0, zhongxu.length - 1);
    }


    private TreeNode build(int[] xianxu, int[] zhongxu, int inStart, int inEnd, int preStart, int preEnd) {
        if (preStart > preEnd) {
            return null;
        }
        //处理一些事
        //根节点是先序便利第1个。
        int rootValue = xianxu[preStart];
        //跟据先找中
        int midIndex = 0;
        for (int i = 0; i < zhongxu.length; i++) {
            if (zhongxu[i] == rootValue) {
                midIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);

        //确定先序便利的左边树的长度， 由中序遍历可以知道
        int leftSize = midIndex - inStart;

        root.left = build(xianxu, zhongxu, inStart, midIndex - 1, preStart + 1, preStart + leftSize);
        root.right = build(xianxu, zhongxu, midIndex + 1, inEnd, preStart + leftSize + 1, preEnd);
        return root;
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
