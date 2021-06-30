package 二叉树集合AA.序列化二叉树;


import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = -1;
        return dfs(arr);
    }

    int index = 0;

    public TreeNode dfs(String[] arr) {
        if (index >= arr.length) {
            return null;
        }
        index++;
        if ("#".equals(arr[index])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));

        root.left = dfs(arr);
        root.right = dfs(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));