package 动态规划AA.旋转图像;

class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //镜像对称
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //将每列反转
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2 ; j++) {
                //最后一个跟第一个交换
                int temp = matrix[i][col - j -1];
                matrix[i][col - j -1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }
}