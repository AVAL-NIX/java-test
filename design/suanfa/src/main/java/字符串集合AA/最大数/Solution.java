package 字符串集合AA.最大数;

import java.util.*;


public class Solution {
    /**
     * 最大数
     *
     * @param nums int整型一维数组
     * @return string字符串
     */
    public String solve(int[] nums) {
        List<String> newList = new ArrayList<>();
        List<String> zero = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            } else if (nums[i] == 0) {
                zero.add("0");
                continue;
            }
            String t = nums[i] + "";
            newList.add(t);
        }
        Collections.sort(newList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) > o2.charAt(0)) {
                    return 1;
                } else if (o1.charAt(0) < o2.charAt(0)) {
                    return -1;
                } else {
                    int i = 0;
                    while (i < o1.length() && i < o2.length() && o1.charAt(i) == o2.charAt(i)) {
                        if (o1.charAt(i) > o2.charAt(i)) {
                            return 1;
                        } else if (o1.charAt(i) < o2.charAt(i)) {
                            return -1;
                        }
                        i++;
                    }
                    //谁长度少谁排前面
                    if (o1.length() == o2.length()) {
                        return 0;
                    } else if (o1.length() < o2.length()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = newList.size() - 1; i >= 0; i--) {
            sb.append(newList.get(i));
        }
        for (int i = 0; i < zero.size(); i++) {
            sb.append("0");
        }
        if (newList.size() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve(new int[]{91, 92, 9, 90, 99, 100}));
    }
}