package 查找算法集合AA.远亲不如近邻;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 远亲不如近邻
     * 2分法
     *
     * @param n int整型 居民个数
     * @param m int整型 方案个数
     * @param a int整型一维数组 居民的位置
     * @param x int整型一维数组 方案对应的位置
     * @return int整型一维数组
     */
    public int[] solve(int n, int m, int[] a, int[] x) {
        int[] res = new int[x.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i < x.length; i++) {
            int value = x[i];
            int left = 0, right = a.length - 1;
            while (left < right) {
                int mid = left + (int) Math.ceil((right - left) / 2.0);
                if (a[mid] < value) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            int min = Math.abs(a[left] - value);
            if (left - 1 >= 0) {
                min = Math.min(min, Math.abs(a[left - 1] - value));
            }
            if (left + 1 < a.length) {
                min = Math.min(min, Math.abs(a[left + 1] - value));
            }
            list.add(min);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 暴利解法
     *
     * @param n
     * @param m
     * @param a
     * @param x
     * @return
     */
    public int[] solve2(int n, int m, int[] a, int[] x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            int value = x[i];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < a.length; j++) {
                min = Math.min(min, Math.abs(a[j] - value));
            }
            list.add(min);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
