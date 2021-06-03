package 动态规划AA.最长递增子序列;

import java.util.*;

/**
 * 没明白。 。 
 */
public class Solution {
    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS(int[] arr) {
        // write code here
        if (arr.length == 0) {
            return new int[]{};
        }
        //记录最长的上升子序列
        int[] dp = new int[arr.length];
        int[] pp = new int[arr.length];

        int maxs = 0, maxi = 0;
        for (int i = 0; i < arr.length; i++) {
            int lmax = 1;
            pp[i] = i;
            for (int k = i - 1; k >= 0; k--) {
                if (arr[i] > arr[k] &&
                        (lmax < dp[k] + 1 || (lmax == dp[k] + 1 && arr[k] < arr[pp[i]]))) {
                    lmax = dp[k] + 1;
                    pp[i] = k;
                } else if (k < lmax) {
                    break;
                }
            }
            dp[i] = lmax;
            if (maxs < lmax || (maxs == lmax && arr[i] < arr[maxi])) {
                maxs = lmax;
                maxi = i;
            }

        }

        List<Integer> res = new ArrayList<>();
        for (int k = maxi; true; k = pp[k]) {
            res.add(arr[k]);
            if (k == pp[k]) {
                break;
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }



//    public int[] LIS2(int[] arr) {
        // write code here
//        if (arr.length == 0) {
//            return new int[]{};
//        }
//        //记录最长的上升子序列
//        int[] dp = new int[arr.length];
//        Arrays.fill(dp,1);
//        //其元素maxEnd[k]表示长度为k+1的递增长子序列的最后一个元素，并且是字典序最小的那个。显然maxEnd是一个递增数组。
//        int[] maxEnd = new int[arr.length];
//
//        for (int i = 0; i < arr.length; i++) {
//            int lmax = 1;
//            pp[i] = i;
//            for (int k = i - 1; k >= 0; k--) {
//                if (arr[i] > arr[k] &&
//                        (lmax < dp[k] + 1 || (lmax == dp[k] + 1 && arr[k] < arr[pp[i]]))) {
//                    lmax = dp[k] + 1;
//                    pp[i] = k;
//                } else if (k < lmax) {
//                    break;
//                }
//            }
//            dp[i] = lmax;
//            if (maxs < lmax || (maxs == lmax && arr[i] < arr[maxi])) {
//                maxs = lmax;
//                maxi = i;
//            }
//
//        }
//
//        List<Integer> res = new ArrayList<>();
//        for (int k = maxi; true; k = pp[k]) {
//            res.add(arr[k]);
//            if (k == pp[k]) {
//                break;
//            }
//        }
//        return res.stream().mapToInt(Integer::valueOf).toArray();
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().LIS(new int[]{1, 2, 6, 8, 7, 5, 2, 4, 32})));
    }
}