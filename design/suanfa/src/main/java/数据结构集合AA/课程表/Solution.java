package 数据结构集合AA.课程表;

import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());

        }

        for(int[] cp : prerequisites){
            indegrees[cp[0]] = indegrees[cp[0]] + 1;
            adjacency.get(cp[1]).add(cp[0]);
        }

        for(int i=0 ; i<numCourses; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
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