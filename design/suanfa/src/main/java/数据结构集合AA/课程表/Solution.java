package 数据结构集合AA.课程表;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // key 存 前值， value 存数组 ， 后值
        Map<Integer, Set<Integer>> pre = new HashMap<>();
        // key 存 后值， value 存数组 ，前值
        Map<Integer, Set<Integer>> last = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];
            if (pre.containsKey(key)) {
                Set<Integer> temp = pre.get(key);
                //检查last
                if (last.containsKey(key)) {
                    Set<Integer> temp2 = last.get(key);
                    temp.addAll(temp2);
                }
                temp.add(value);
                pre.put(key, temp);
            } else {
                Set<Integer> temp = new HashSet<>();
                temp.add(value);
                pre.put(key, temp);
            }
            //加入后置 ，形成连续
            if (last.containsKey(value)) {
                Set<Integer> temp = last.get(value);
                temp.add(key);
                last.put(value, temp);
            } else {
                Set<Integer> temp = new HashSet<>();
                temp.add(key);
                last.put(value, temp);
            }
            boolean preFlag = pre.containsKey(value) && pre.get(value).contains(key);
            boolean lastFlag = last.containsKey(key) && last.get(key).contains(value);
            if (preFlag) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(3, new int[][]{{1, 0}, {0, 2}, {2, 1}}));
        System.out.println(new Solution().canFinish(3, new int[][]{{1, 0}}));
    }
}