package 动态规划AA.两个字符串的删除操作;

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length() ;
        int len2 = word2.length();
        int strLen = minLength(word1 ,  word2);
        return len1 - strLen + len2 - strLen;
    }

    int[][] dp;
    public int minLength(String word1, String word2){
        dp = new int[word1.length()][word2.length()];
        return dp(word1,0, word2, 0);
    }


    public int dp(String s1, int i, String s2, int j){
        //base case
        if(s1.length() == i || s2.length() == j){
            return 0;
        }
        // rep
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+ dp(s1, i+1, s2, j+1);
        }else{
            dp[i][j] = Math.max(dp(s1, i+1, s2, j) , dp(s1, i, s2, j+1));
        }
        return dp[i][j];
    }

}