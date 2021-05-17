package 二叉树集合AA.填充每个节点的下一个右侧节点指针;

import common.Node;

class Solution {
    public Node connect(Node root) {
        //base case
        if(root == null ){
            return root;
        }
        connectTwo(root.left, root.right);

        return root;
    }

    public void connectTwo(Node left, Node right){
        if (left == null || right == null) {
            return;
        }
        //连接传入的2个点节点
        left.next = right;

        //连接自己的2个节点
        connectTwo(left.left, left.right);
        connectTwo(right.left, right.right);

        // 连接跨越父节点的两个子节点
        connectTwo(left.right, right.left);
    }
}
