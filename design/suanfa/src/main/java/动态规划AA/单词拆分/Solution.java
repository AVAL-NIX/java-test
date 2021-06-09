package 动态规划AA.单词拆分;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() +1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <i ; j++) {
                //减枝
                if(dp[i] == true) break;
                if(dp[j] == false) continue;
                String s1 = s.substring(j, i);
                if (set.contains(s1) && dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}