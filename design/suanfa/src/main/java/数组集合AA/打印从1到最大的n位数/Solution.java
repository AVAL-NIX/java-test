package 数组集合AA.打印从1到最大的n位数;

class Solution {
    public int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max += Math.pow(10, i) * 9;
        }
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}