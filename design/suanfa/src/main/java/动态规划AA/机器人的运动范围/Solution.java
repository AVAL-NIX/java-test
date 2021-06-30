package 动态规划AA.机器人的运动范围;

class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m,n,0,0, k ,visited);
    }

    public int dfs(int m,int n, int i, int j, int k , boolean[][] visited){
        if( i >= m || j >= n || visited[i][j] || getSum(i) + getSum(j) > k ){
            return 0;
        }
        //防止重复
        visited[i][j] = true;
        return 1 + dfs(m,n, i + 1, j , k ,visited) + dfs(m,n, i, j + 1, k, visited);
    }

    public int getSum(int x ){
        int res = 0 ;
        while(x!=0){
            res += x% 10;
            x /= 10;
        }
        return res;
    }
}