package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengxin
 * @date 2021/3/16
 */
public class TreeNode {

    public int data;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String result = " [data :" + data;
        if (left != null) {
            result += " left : " + left.toString();
        }
        if (right != null) {
            result +=  " right : " + right.toString();
        }
        result+="]";
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        List<Integer> result = new ArrayList<Integer>();
        for(int i =0; i < matrix.length ; i++){
            for(int j =0; j < matrix[i].length; j++){
                result.add(matrix[i][j]);
            }
        }
    }
}
