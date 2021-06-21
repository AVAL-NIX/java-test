package 回溯算法AA.主持人调度;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算成功举办活动需要多少名主持人
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        // write code here
        int[] startArr = new int[n];
        int[] endArr = new int[n];
        for (int i = 0; i < n; i++) {
            startArr[i] = startEnd[i][0];
            endArr[i] = startEnd[i][1];
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);
        int endIndex = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (startArr[i] >= endArr[endIndex]) {
                endIndex++;
            } else {
                count++;
            }

        }
        return count;
    }

    public int minmumNumberOfHost2(int n, int[][] startEnd) {
        // 排序，头相等的，尾从小到大
        // 头不相等的头从小到大
        Arrays.sort(startEnd, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr1[1] - arr2[1];
                }
                return arr1[0] - arr2[0];
            }
        });
        // 默认升序
        int min = Integer.MIN_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(min);
        for (int i = 0; i < n; i++) {
            // 只提供结束时间，如果当前的开始时间小于队首的结束时间，说明没空闲
            // 如果当前的开始时间大于队首的结束时间，说明可以空闲一个，队首出队
            if (queue.peek() <= startEnd[i][0]) {
                queue.poll();
            }
            queue.offer(startEnd[i][1]);
        }
        return queue.size();
    }
}