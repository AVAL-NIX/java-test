package 动态规划AA.岛屿数量;

import java.util.*;


public class Solution {
    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[] visited = new boolean[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i]) {
                    //如果当是格子
                }

            }

        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j]= '0';
        dfs(grid,i -1 , j);
    }
}