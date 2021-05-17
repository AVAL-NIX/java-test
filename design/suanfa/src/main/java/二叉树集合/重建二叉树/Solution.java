package 二叉树集合.重建二叉树;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //base case
        if (pre.length == 0) {
            return null;
        }
        return build(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }


    public TreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //base case
        if (preStart > preEnd) {
            return null;
        }
        int rootVale = pre[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootVale) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVale);

        int leftSize = index - inStart;
        root.left = build(pre, preStart + 1, preStart + leftSize, in, inStart, index - 1);
        root.right = build(pre, preStart + leftSize + 1, preEnd, in, index + 1, inEnd);
        return root;
    }


    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new Solution().reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
    }

}


