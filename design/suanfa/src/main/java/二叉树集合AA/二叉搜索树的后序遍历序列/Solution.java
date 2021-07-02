package 二叉树集合AA.二叉搜索树的后序遍历序列;

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        //base case
        if (i >= j) {
            return true;
        }
//        划分左右子树：
//        遍历后序遍历的 [i, j] 区间元素，
//        寻找 第一个大于根节点 的节点，索引记为 m 。
//        此时，可划分出左子树区间 [i,m-1] 、
//        右子树区间 [m, j - 1]、根节点索引 j 。
        //后序遍历最后一个是跟节点， 比他大的都是右树， 比他小的都是左树
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
//        判断是否为二叉搜索树：
//        左子树区间 [i,m−1] 内的所有节点都应 < postorder[j] 。
//        而第 1.划分左右子树 步骤已经保证左子树区间的正确性，
//        因此只需要判断右子树区间即可。
//        右子树区间[m,j−1] 内的所有节点都应 >postorder[j] 。
//        实现方式为遍历，当遇到 ≤postorder[j]
//        的节点则跳出；则可通过 p = j  判断是否为二叉搜索树。

//        返回值： 所有子树都需正确才可判定正确，因此使用 与逻辑符 && 连接。
//        p = j： 判断 此树 是否正确。
//        recur(i, m - 1)： 判断 此树的左子树 是否正确。
//        recur(m, j - 1) ： 判断 此树的右子树 是否正确。

        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}