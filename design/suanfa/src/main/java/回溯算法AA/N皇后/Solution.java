package 回溯算法AA.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], ".");
        }
        tarck(board, 0);
        return res;
    }

    private void tarck(String[][] board, int i) {
        if (i == board.length) {
            List<String> t = new ArrayList<>();
            for (int k = 0; k < board.length; k++) {
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < board[i].length; l++) {
                    sb.append(board[k][l]);
                }
                t.add(sb.toString());
            }
            res.add(t);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            //排除不合法选择
            if (!isValid(board, i, j)) {
                continue;
            }
            // 做选择
            board[i][j] = "Q";
            // 进入下一行决策
            tarck(board, i + 1);
            // 撤销选择
            board[i][j] = ".";
        }
    }

    private boolean isValid(String[][] board, int col, int row) {
        int n = board.length;
        //检查列是否有皇后冲突
        for (int k = 0; k < n; k++) {
            if (board[k][row].equals("Q")) {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int k = col - 1, k1 = row + 1; k >= 0 && k1 < n; k--, k1++) {
            if (board[k][k1].equals("Q")) {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int k = col - 1, k1 = row - 1; k >= 0 && k1 >= 0; k--, k1--) {
            if (board[k][k1].equals("Q")){
                return false;
            }
        }

        return true;
    }
}