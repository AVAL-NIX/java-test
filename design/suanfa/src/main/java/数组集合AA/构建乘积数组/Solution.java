package 数组集合AA.构建乘积数组;

import java.util.ArrayList;

public class Solution {
    /**
     * 运行时间：13ms
     * 超过66.66% 用Java提交的代码
     * 占用内存：9640KB
     * 超过7.44%用Java提交的代码
     *
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


    public int[] multiply2(int[] A) {
        int n = A.length;
        //维护2个数组，用空间换时间
        int[] left = new int[n];
        int[] right = new int[n];
        //根据上面已经知道第0个是1
        left[0] = 1;
        //这里下标从1开始
        for (int i = 1; i < n; i++) {
            //根据计算左边得出结论。left[n] = left[n-1] * A[n-1]
            left[i] = left[i - 1] * A[i - 1];
        }
        //根据计算右边知道，第n-1个是1
        right[n - 1] = 1;
        // 这里下标从数组第2个值开始，第一个值已经是 1 了
        for (int i = n - 2; i >= 0; i--) {
            //根据计算右边得出结论。right[n] = A[n+1] + right[n+1]
            right[i] = right[i + 1] * A[i + 1];
        }

        //开始计算B数组
        int[] B = new int[n];
        for (int i = 0; i < n; i++){
            B[i] = left[i] * right[i];
        }
        return B;
    }

    public int[] multiply3(int[] A) {
        int n = A.length;
        //维护2个数组，用空间换时间 ,这里可以用B数组代替left数组，达到节约一个额外数组
        int[] B = new int[n];
        int[] right = new int[n];
        //根据上面已经知道第0个是1
        B[0] = 1;
        //这里下标从1开始
        for (int i = 1; i < n; i++) {
            //根据计算左边得出结论。left[n] = left[n-1] * A[n-1]
            B[i] = B[i - 1] * A[i - 1];
        }
        //根据计算右边知道，第n-1个是1
        right[n - 1] = 1;
        // 这里下标从数组第2个值开始，第一个值已经是 1 了
        for (int i = n - 2; i >= 0; i--) {
            //根据计算右边得出结论。right[n] = A[n+1] + right[n+1]
            right[i] = right[i + 1] * A[i + 1];
        }

        //开始计算B数组
        for (int i = 0; i < n; i++){
            B[i] = B[i] * right[i];
        }
        return B;
    }


    public int[] multiply4(int[] A) {
        int n = A.length;
        //维护2个数组，用空间换时间 ,这里可以用B数组代替left数组，达到节约一个额外数组
        int[] B = new int[n];
        //根据上面已经知道第0个是1
        B[0] = 1;
        //这里下标从1开始
        for (int i = 1; i < n; i++) {
            //根据计算左边得出结论。left[n] = left[n-1] * A[n-1]
            B[i] = B[i - 1] * A[i - 1];
        }
        //根据计算右边知道，第n-1个是1
        int right = 1;

        //开始计算B数组
        for (int i = n - 2; i >= 0 ; i--){
            //根据计算右边得出结论。right[n] = A[n+1] + right[n+1]
            right = right * A[i+1];
            // B[i] = left[i] * right[i]
            B[i] = B[i] * right;
        }
        return B;
    }

}