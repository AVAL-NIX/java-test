package 二叉树集合AA.二叉搜索树与双向链表;

import common.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root);

        //头尾  pre = 最后的节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        if (pre == null) {
            head = root;
        } else if (pre != null) {
            pre.right = root;
        }
        root.left = pre;
        pre = root;

        dfs(root.right);
    }
}