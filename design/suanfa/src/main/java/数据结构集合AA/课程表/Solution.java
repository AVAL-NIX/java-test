package 数据结构集合AA.课程表;

import java.util.*;

/**
 * todo 需要学习
 */
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 入度表，记录每个前缀值出现多少次
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }

        for(int[] cp : prerequisites){
            // 统计前缀值出现的次数【 每个下标代表是课程】
            indegrees[cp[0]]++;
            // 统计每个后缀的值出现的次数，需要的前缀次数
            adjacency.get(cp[1]).add(cp[0]);
        }

        for(int i=0 ; i<numCourses; i++){
            // 如果前缀值是0 ，加入， 课程为0
            if(indegrees[i] == 0){
                queue.add(i); // 课程加入队列
            }
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            // 将需要的课程拿出来。
            for(int cur: adjacency.get(pre)){
                if(--indegrees[cur] == 0){
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(3, new int[][]{{1, 0}, {0, 2}, {2, 1}}));
        System.out.println(new Solution().canFinish(3, new int[][]{{1, 0}}));
    }
}