package 动态规划AA.单源最短路;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n     int 顶点数
     * @param m     int 边数
     * @param graph int二维数组 一维3个数据，表示顶点到另外一个顶点的边长度是多少​
     * @return int
     */
    public int findShortestPath(int n, int m, int[][] graph) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //构造图
        for (int i = 0; i < graph.length; i++) {
            int[] edge = graph[i];
            dp[edge[0] - 1][edge[1] - 1] = Math.min(edge[2], dp[edge[0] - 1][edge[1] - 1]);
        }
        boolean[] used = new boolean[n];
        used[0] = true;
        dfs(0, n, 0, dp, used);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(int curr, int n, int dst, int[][] graph, boolean[] used) {
        if (curr == n - 1) {
            min = Math.min(min, dst);
            return;
        }

        for (int i = 0; i < n; i++) {
            //如果有边可达，还没有被用
            if (graph[curr][i] != Integer.MAX_VALUE && !used[i]) {
                used[i] = true;
                dfs(i, n, dst + graph[curr][i], graph, used);
                used[i] = false;
            }
        }
    }

    public int min = Integer.MAX_VALUE;
}