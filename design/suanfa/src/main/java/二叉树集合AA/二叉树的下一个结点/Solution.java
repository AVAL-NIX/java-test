package 二叉树集合AA.二叉树的下一个结点;

import java.util.ArrayList;
import java.util.List;

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    List<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode curr = pNode;
        while (curr.next != null) {
            curr = curr.next;
        }
        dfs(curr);
        // curr 是顶节点
        for (int i = 0; i < list.size(); i++) {
            if (pNode.val == list.get(i).val) {
                if (i + 1 < list.size()) {
                    return list.get(i + 1);
                }
            }
        }
        return null;
    }

    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        // 分析3种情况
        //有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
        if (pNode.right != null ) {
            TreeLinkNode temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        //无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点，
        if(pNode.next!=null && pNode.next.left == pNode){
            return pNode.next;
        }
        //无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，
        // 直到找到某个结点是其父结点的左子树，如果存在这样的结点，
        // 那么这个结点的父结点就是我们要找的下一结点。
        // 例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以 G 没有下一结点
        if(pNode.next!=null && pNode.next.right == pNode){
            TreeLinkNode temp = pNode.next;
            while (temp.next!=null && temp.next.right == temp){
                temp = temp.next;
            }
            return temp.next;
        }
        return null;
    }


    public void dfs(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}


