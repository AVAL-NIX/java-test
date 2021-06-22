package 数组集合AA.构建乘积数组;

import java.util.ArrayList;

public class Solution {
    /**
     *  运行时间：13ms
 *     超过66.66% 用Java提交的代码
 *     占用内存：9640KB
 *     超过7.44%用Java提交的代码
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                sum = sum * A[j];
            }
            B[i] = sum;
        }
        return B;
    }
}