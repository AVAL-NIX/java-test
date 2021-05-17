package 二叉树集合.树的直径;

import lombok.Data;
import sun.reflect.generics.tree.Tree;

/*
 * public class Interval {
 *   int start;
 *   int end;
 * }
 */

public class Solution {
    public class Interval {
        int start;
        int end;
    }


    /**
     * 树的直径
     *
     * @param n          int整型 树的节点个数
     * @param Tree_edge  Interval类一维数组 树的边
     * @param Edge_value int整型一维数组 边的权值
     * @return int整型
     */
    public int solve(int n, Interval[] Tree_edge, int[] Edge_value) {
        if (n == 0) {
            return 0;
        }
        // 构建2叉树
        TreeNode root = new TreeNode(Tree_edge[0].start, Edge_value[0]);
        for (int i = 1; i < Tree_edge.length - 1; i++) {
            Interval curr = Tree_edge[i];
            if(curr.start == Tree_edge[i-1].end){

            }
          //  TreeNode temp = new TreeNode(curr.start, Edge_value[i]);
            //构建左右

        }
        return 0;
    }

    public int index = 0;
    public TreeNode build(Interval[] Tree_edge, int[] Edge_value){
        TreeNode root = new TreeNode(Tree_edge[index].start, Edge_value[index]);
        Interval curr = Tree_edge[index];
        index++;
        root.left = build(Tree_edge , Edge_value);
        root.right = build(Tree_edge , Edge_value);
        return root;
    }


    public class TreeNode {

        public int val;
        public int weight;

        public TreeNode left;

        public TreeNode right;


        TreeNode() {
        }


        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }
}
