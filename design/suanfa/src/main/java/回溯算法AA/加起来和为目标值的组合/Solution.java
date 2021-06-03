package 回溯算法AA.加起来和为目标值的组合;

import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        LinkedList<Integer> temp = new LinkedList<>();
        Arrays.sort(num);
        trackFn(num, 0, 0, target, temp, null);
        return res;
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    /**
     *
     * @param num
     * @param sum  和 ， 用空间，避免循环list
     * @param start 开始下标
     * @param target 要统计的和
     * @param temp  要统计的数组
     * @param visited  判断是否访问过。 这里不 需要
     */
    public void trackFn(int[] num, int sum, int start, int target, LinkedList<Integer> temp, int[] visited) {
        if (!res.contains(temp) && isEquals(target, sum)) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < num.length; i++) {
            //剪枝， 不然过不了。
            if (sum > target) {
                continue;
            }

            temp.add(num[i]);
            sum += num[i];

            trackFn(num, sum, i + 1, target, temp, null);

            sum -= num[i];
            temp.removeLast();
        }
    }

    private boolean isEquals(int target, int sum) {
        return sum == target;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{100, 10, 20, 70, 60, 10, 50}, 80).toString());
    }
}