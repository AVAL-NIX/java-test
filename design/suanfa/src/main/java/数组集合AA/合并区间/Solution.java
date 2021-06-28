package 数组集合AA.合并区间;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                //合并右区间
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            return res;
        }
        //排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });
        //遍历
        for (int i = 0; i < intervals.size(); i++) {
            if (res.size() == 0 || res.get(res.size() - 1).end < intervals.get(i).start) {
                res.add(intervals.get(i));
            } else {
                //合并右边区间
                Interval interval = res.get(res.size() - 1);
                interval.end = Math.max(intervals.get(i).end, interval.end);
                res.set(res.size() - 1, interval);
            }
        }
        return res;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    /**
     * 最高效的解法
     *
     * @param intervals
     * @return
     */
    public int[][] merge3(int[][] intervals) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); ) {
                    if (check(list.get(i), list.get(j)) || check(list.get(j), list.get(i))) {
                        list.get(i)[0] = Math.min(list.get(i)[0], list.get(j)[0]);
                        list.get(i)[1] = Math.max(list.get(i)[1], list.get(j)[1]);
                        flag = true;
                        list.remove(j);
                    } else {
                        j++;
                    }
                }
            }
        }
        int[][] res = new int[list.size()][2];
        res = list.toArray(res);
        return res;
    }

    private boolean check(int[] nums1, int[] nums2) {
        return nums1[1] >= nums2[0] && nums1[1] <= nums2[1] || nums1[0] >= nums2[0] && nums1[0] <= nums2[1];
    }

}

