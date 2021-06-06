package 动态规划AA.最长回文子串;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * <p>
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 *
 * @author zhengxin
 * @date 2021/4/2
 */
public class Solution {

    /**
     * 暴利解法
     * 18行动态规划+27行中心扩散法+36行马拉车算法
     *
     * @param A
     * @param n
     * @return
     */

    public String longestPalindrome(String s) {
        int len = s.length();
        String max = "";
        for(int i= 0; i < len; i++){
            for(int j = i ; j <= len ; j++){
                String s1 = s.substring(i,j);
                if(isMaxStr(s1)){
                    if(s1.length() > max.length()){
                        max = s1;
                    }
                }
            }
        }
        return max;
    }

    public boolean isMaxStr(String s){
        int n = s.length();
        for(int i=0 ; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(n -1 -i)){
                return false;
            }

        }
        return true;
    }


    /**
     * 动态规划
     */

    public String longestPalindrome2(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //状态转移
        // 先枚举子串长度
        for (int i = 2; i < len; i++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int l = 0; l < len; l++) {
                // l + r = i
                //右边界下标为 1   r - l + 1 == i ;
                // 由 L 和 i 可以确定右边界，即 r - l + 1 = i 得
                int r = i + l - 1;
                if(r >= len){
                    break;
                }

                if(s.charAt(l) != s.charAt(r)){
                    dp[l][r] = false;
                }else{
                    // base case 字符串长度为 2- 3  时候。 不用判断之前是不是为回文
                    if(r - l  + 1 < 4){
                        dp[l][r] = true;
                    }else{
                        //获取之前的是否是回文串
                        dp[l][r] = dp[l+1][r-1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[l][r] && r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    begin = l;
                }


            }
        }
        return s.substring(begin, begin+maxLen);
    }

    public String longestPalindrome3(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int begin = 0;
        int maxLen = 1;

        //定义
        for(int i=0; i < len ; i++){
            int left = i - 1;
            int right = i + 1;
            int currLen = 1;
            while(left >=0 && s.charAt(left) == s.charAt(i)){
                currLen++;
                left--;
            }
            while(right <len && s.charAt(i) == s.charAt(right)){
                currLen++;
                right++;
            }
            while(left >=0 && right <len && s.charAt(left) == s.charAt(right)){
                currLen+= 2;
                left--;
                right++;
            }
            if(currLen > maxLen){
                maxLen = currLen;
                begin = left;
            }
        }

        return s.substring(begin+1, begin + maxLen + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome3("abbbdfasdf"));
    }

}
