package 寻找重复的子树;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    //记录所有子树
    public HashSet<String> memo = new HashSet<>();
    public HashMap<String, Integer> memo2 = new HashMap<>();
    //记录重复的子树根节点
    public LinkedList<TreeNode> res = new LinkedList<>();

    public String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;
        int flat = memo2.getOrDefault(subTree, 0);
        if (flat == 1) {
            //有人跟我重复我把自己加入结果队列
            res.add(root);
        }
        //没有人跟我重复， 我把自己加入集合
        memo2.put(subTree, flat + 1);

        return subTree;
    }
}
