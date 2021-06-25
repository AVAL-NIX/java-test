package 滑动窗口集合AA.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1;
        int sum = 0;
        LinkedList<Integer> temp = new LinkedList<>();
        List<LinkedList<Integer>> res = new ArrayList<>();
        while (left < target && right < target) {
            //开始滑动
            if (right < target) {
                sum += right;
                temp.addLast(right);
            }
            right++;

            while ((sum >= target)) {
                if (sum == target) {
                    res.add(new LinkedList<>(temp));
                }
                if (temp.size() > 0) {
                    sum -= left;
                    temp.removeFirst();
                }
                left++;
            }
        }
        int[][] r = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            LinkedList<Integer> tlink = res.get(i);
            int[] t = new int[tlink.size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                t[j] = tlink.get(j);
            }
            r[i] = t;
        }
        return r;
    }

    public static void main(String[] args) {
        new Solution().findContinuousSequence(9);
    }
}