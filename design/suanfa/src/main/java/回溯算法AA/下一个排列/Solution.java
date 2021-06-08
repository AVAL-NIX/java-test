package 回溯算法AA.下一个排列;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public void nextPermutation(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        track(nums, temp, 0 , nums.length);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> t = res.get(i);
            int count = 0;
            for (int j = 0; j < t.size(); j++) {
                if (t.get(j) > nums[j]) {
                    count++;
                }
                if (t.get(j) < nums[j]) {
                    break;
                }
            }
            if (count >= 1) {
                //交换
                for (int j = 0; j < t.size(); j++) {
                    nums[j] = t.get(j);
                }
                return;
            }
        }
        //如果全都没有取第0个。
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        List<Integer> t = res.get(0);
        //交换
        for (int j = 0; j < t.size(); j++) {
            nums[j] = t.get(j);
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    List<String> res1 = new ArrayList<>();

    private void track(int[] nums, List<Integer> temp, int start, int end) {
        if (start == end) {
            List<Integer> result = Arrays.stream(nums).boxed().collect(Collectors.toList());
            String a = result.toString();
            if(res1.contains(a)){
                return;
            }
            res.add(result);
            res1.add(a);
            return;
        }
        for (int i = start ; i < nums.length ; i++) {
            swap(nums, start, i);
            System.out.println("aaaaaaaa");
            track(nums, temp, start  + 1 , end);
            swap(nums, start, i);
        }
    }


    //数组中的两个元素交换位置
    private void swap(int[] array, int i, int j) {
        if(i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] n = new int[]{2,2,7};
        new Solution().nextPermutation(n);
        System.out.println(Arrays.toString(n));

    }
}