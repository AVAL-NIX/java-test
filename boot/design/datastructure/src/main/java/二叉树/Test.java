package 二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author zhengxin
 * @date 2021/3/16
 */
public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] integers = {1, 2, 3, 0, 4, 5, 0, 0, 6, 0, 0, 7, 0, 0, 8, 0, 9, 10, 0, 0, 0};
        for (int i = 0; i < integers.length; i++) {
            list.add(integers[i]);
        }
        TreeNode tree = createTree(list);
        System.out.println(" tree: " + tree.toString());
        System.out.println(" ------前序------");
        preList(tree);
        System.out.println("");
        System.out.println("------非递归------");
        preListWithStack(tree);
        System.out.println("");
        System.out.println("--------中序-----");
        midList(tree);
        System.out.println("");
        System.out.println("-------非递归------");
        midListWithStack(tree);
        System.out.println("");
        System.out.println("-------后序------");
        afterList(tree);
        System.out.println("");
        System.out.println("-------非递归------");
        afterListWithStack(tree);

        System.out.println("");
        System.out.println("-------层序遍历------");
        layerList(tree);
    }


    /**
     * 创建二叉树
     *
     * @param list
     * @return
     */
    public static TreeNode createTree(LinkedList<Integer> list) {
        TreeNode treeNode = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Integer data = list.removeFirst();
        if (data != null && data != 0) {
            treeNode = new TreeNode(data);
            treeNode.left = createTree(list);
            treeNode.right = createTree(list);
        }
        return treeNode;
    }


    /**
     * 首先来看前序遍历，所谓的前序遍历就是先访问根节点，再访问左节点，最后访问右节点，
     * 二叉树前序遍历   根-> 左-> 右
     *
     * @param treeNode
     */
    public static void preList(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.data + ",");
        preList(treeNode.left);
        preList(treeNode.right);
    }


    /**
     * 二叉树中序遍历   左-> 根-> 右
     * 再者就是中序遍历，所谓的中序遍历就是先访问左节点，再访问根节点，最后访问右节点，
     */
    public static void midList(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midList(treeNode.left);
        System.out.print(treeNode.data + ",");
        midList(treeNode.right);
    }


    /**
     * 最后就是后序遍历，所谓的后序遍历就是先访问左节点，再访问右节点，最后访问根节点。
     * 二叉树后序遍历   左-> 右-> 根
     *
     * @param treeNode
     */
    public static void afterList(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        afterList(treeNode.left);
        afterList(treeNode.right);
        System.out.print(treeNode.data + ",");
    }


    /**
     * 非递归方式 进行遍历
     *
     * 还是一样，先看非递归前序遍历
     *
     * 1. 首先申请一个新的栈，记为stack；
     * 2. 声明一个结点treeNode，让其指向node结点；
     * 3. 如果treeNode的不为空，将treeNode的值打印，并将treeNode入栈，然后让treeNode指向treeNode的右结点，
     * 重复步骤3，直到treenode为空；
     * 然后出栈，让treeNode指向treeNode的右孩子
     * 重复步骤3，直到stack为空.
     *
     * **/

    /**
     * 二叉树前序遍历   根-> 左-> 右
     */
    public static void preListWithStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (treeNode == null) {
            return;
        }
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.data + ",");
                stack.add(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 二叉树中序遍历   左-> 根-> 右
     */
    public static void midListWithStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (treeNode == null) {
            return;
        }
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.add(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.data + ",");
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 二叉树后序遍历   左 -> 右-> 根
     * 后序遍历非递归实现，后序遍历这里较前两者实现复杂一点，我们需要一个标记位来记忆我们此时节点上一个节点
     */
    public static void afterListWithStack(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (treeNode == null) {
            return;
        }
        TreeNode flag = null;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.add(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                //判断有没有右孩子， 如果有右孩子， 记得入栈
//                * 这块就是判断treeNode是否有右孩子，
//                 * 如果没有输出treeNode.data，让lastVisit指向treeNode，并让treeNode为空
//                 * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
//                treeNode.right == null  是右孩子的判断条件， 或者根节点没有右孩子节点。
//                如果根节点有右孩子节点 。 treeNode.right == flag 这个条件可以跳出循环
                if (treeNode.right == null || treeNode.right == flag) {
                    System.out.print(treeNode.data + ",");
                    // 这里是用来标记避免重复循环的 ， 避免右孩子的根节点重复 右-根-右-根
                    flag = treeNode;
                    // 打印过就跳出。
                    treeNode = null;
                } else {
                    // 如果有右孩子，根孩子重新入栈
                    stack.add(treeNode);
                    // treeNode.left 已经打印过了。 遍历右孩子
                    treeNode = treeNode.right;
                }

            }
        }
    }

    /**
     * 一层一层的遍历
     * 正确答案应该是  1，2，8，3，7，9，4，10，5，6
     * 需要用队列。
     *
     * @param tree
     */
    private static void layerList(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            tree = queue.poll();
            System.out.print(tree.data + " ");
            if (tree.left != null)
                queue.add(tree.left);
            if (tree.right != null)
                queue.add(tree.right);
        }
    }

}
