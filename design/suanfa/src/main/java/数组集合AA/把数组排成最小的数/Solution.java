package 数组集合AA.把数组排成最小的数;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String minNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "";
                String s2 = o2 + "";
                int i = 0, j = 0;
                while (i < s1.length() && j < s2.length()) {
                    if (s1.charAt(i) < s2.charAt(j)) {
                        return -1;
                    } else if (s1.charAt(i) > s2.charAt(j)) {
                        return 1;
                    }
                    i++;
                    j++;
                }
                if (s1.length() == s2.length()) {
                    return 0;
                }
                //如果相等， 且 o1, o2 长度不相等
                //针对长的第2位是否小于第1位
                // 30 排在 3 前面
                // 30 排在 3 前面
                if (s1.length() > s2.length()) {
                    // 0 < 3  ?
                    while (i < s1.length()) {
                        //如果前面的大 ， 放后面
                        if (s1.charAt(i) < s1.charAt(0)) {
                            return -1;
                        } else if (s1.charAt(i) > s1.charAt(0)) {
                            return 1;
                        }
                        i++;
                    }
                    //一直相等返回0
                    return 0;
                } else {
                    while (j < s2.length()) {
                        //如果前面的大 ， 放后面
                        if (s2.charAt(j) < s2.charAt(0)) {
                            return 1;
                        } else if (s2.charAt(j) > s2.charAt(0)) {
                            return -1;
                        }
                        j++;
                    }
                    return 0;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num == 0) {
                continue;
            }
            sb.append(num);
        }
        return sb.toString();
    }


    public String minNumber2(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "";
                String s2 = o2 + "";
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num == 0) {
                continue;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
    }
}