package 动态规划AA.最长公共子串;


import java.util.Arrays;

/**
 * https://mp.weixin.qq.com/s/ZhPEchewfc03xWv9VP3msg
 */
public class Solution {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        int[][] meno = new int[str1.length()][str2.length()];
        meno[0][0] = 1;

        int index = 0, maxLength = 0;
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        meno[i][j] = 1;
                    } else {
                        meno[i][j] = meno[i - 1][j - 1] + 1;
                    }
                    if (meno[i][j] > maxLength) {
                        maxLength = meno[i][j];
                        index = i;
                    }
                }

            }

        }
        return maxLength == 0 ? "" : str1.substring(index - maxLength + 1, index + 1);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().LCS(
                "2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80", "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2"

        ));
    }
}
