package 二叉树集合.序列化二叉树;

import common.TreeNode;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        //用先序遍历很简单 ， 因为先序是  中 ， 左，  右 ， 所有用index下标控制就行了。
        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }


    TreeNode Deserialize(String str) {
        String[] arr = str.split(",");
        return buildTree(arr);
    }

    public int index = 0;

    private TreeNode buildTree(String[] arr) {
        String curr = arr[index];
        index++;
        if (curr.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = buildTree(arr);
        root.right = buildTree(arr);
        return root;
    }
}
