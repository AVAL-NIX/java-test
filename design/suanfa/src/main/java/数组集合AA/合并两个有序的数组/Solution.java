package 数组集合AA.合并两个有序的数组;

/**
 * 给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
 * 注意：
 * 可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = m - 1, resultIndex = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[resultIndex--] = A[i--];
            } else {
                A[resultIndex--] = B[j--];
            }
        }
        //如果B没有遍历完，那么之间丢在A数组里面
        while (j >= 0) {
            A[resultIndex--] = B[j--];
        }
    }
}
