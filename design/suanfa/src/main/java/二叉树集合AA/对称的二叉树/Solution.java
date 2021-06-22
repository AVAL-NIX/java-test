package 二叉树集合AA.对称的二叉树;

import common.TreeNode;
import common.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<TreeNode> arr = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode temp = q.poll();
                arr.add(temp);
                if (temp == null) {
                    continue;
                }
                q.add(temp.left);
                q.add(temp.right);
            }
            //验证
            if (arr.size() % 2 != 0) {
                return false;
            }
            for (int i = 0, j = arr.size() - 1; i < arr.size() / 2; i++, j--) {
                if(arr.get(i) != null && arr.get(j) != null){
                    if(arr.get(i).val != arr.get(j).val){
                        return false;
                    }
                    continue;
                }
                if(arr.get(i) != arr.get(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}