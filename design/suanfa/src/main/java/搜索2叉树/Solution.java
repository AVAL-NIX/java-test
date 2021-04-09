import java.util.ArrayList;

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
/**
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 *
 * @author zhengxin
 * @date 2021/3/30
 */
public class Solution {


    /**
     * 遍历 , 应该要用栈操作
     * 1.二叉搜索树的左节点都小于或等于根节点，
     * 2.二叉搜索树的右节点都大于或等于根几点，
     * 3.二叉搜索树的中序遍历是从小到大的顺序遍历的，
     * 4.利用二叉搜索树中序遍历是有序的特点，
     * 5.找到第k节点小的下表，并返回。
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null){return null;}
        mid(pRoot);
        System.out.println(list);
        if(k<1||list.size()<k){
            return null;
        }else{
            return list.get(k-1);
        }
    }
    ArrayList<TreeNode> list = new ArrayList<>();
    //递归遍历二叉搜索树
    public void mid(TreeNode pRoot){
        if(pRoot!=null){
            mid(pRoot.left);
            list.add(pRoot);
            mid(pRoot.right);
        }
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


}


