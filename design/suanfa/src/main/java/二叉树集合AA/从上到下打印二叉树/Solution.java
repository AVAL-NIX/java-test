package 二叉树集合AA.从上到下打印二叉树;


import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode t = q.poll();
                if(t.left !=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                res.add(t.val);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}