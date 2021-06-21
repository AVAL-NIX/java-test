package 动态规划AA.分割数组为连续子序列;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

class Solution {

    public boolean isPossible2(int[] nums) {

        //代表牌有几张  key 牌的序号， value 牌的数量
        HashMap<Integer, Integer> freq = new HashMap<>();
        //那个位置需要牌    key 牌的序号， value 牌的数量
        HashMap<Integer, Integer> need = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            // freq中已经没有这个数据了
            if (freq.getOrDefault(nums[i], 0) == 0) {
                continue;
            }
            // 如果need中有这个牌， 又需要数量大于0
            if (need.getOrDefault(value, 0) > 0) {
                // freq 中减一
                freq.put(value, freq.get(value) - 1);
                // need 中对value 的需求 减一
                need.put(value, need.get(value) - 1);
                // 对 value+ 1需求 加一
                need.put(value + 1, need.getOrDefault(value + 1, 0) + 1);
            } else if (freq.getOrDefault(value, 0) > 0 &&
                    freq.getOrDefault(value + 1, 0) > 0 &&
                    freq.getOrDefault(value + 2, 0) > 0) {
                //可以组成顺子
                freq.put(value, freq.get(value) - 1);
                freq.put(value + 1, freq.get(value + 1) - 1);
                freq.put(value + 2, freq.get(value + 2) - 1);
                //需求+1
                need.put(value + 3, need.getOrDefault(value + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * 打印子序列
     *
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {

        //代表牌有几张  key 牌的序号， value 牌的数量
        HashMap<Integer, Integer> freq = new HashMap<>();
        //那个位置需要牌    key 牌的序号， value 牌的数量
        // need[6] = {
        //     {3,4,5},
        //     {2,3,4,5},
        // }
        HashMap<Integer, LinkedList<LinkedList<Integer>>> need = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            // freq中已经没有这个数据了
            if (freq.getOrDefault(nums[i], 0) == 0) {
                continue;
            }
            // 如果need中有这个牌， 又需要数量大于0
            if (need.getOrDefault(value, new LinkedList<>()).size() > 0) {
                // freq 中减一
                freq.put(value, freq.get(value) - 1);
                // need 中对value 的需求 减一
                LinkedList<LinkedList<Integer>> temp = need.getOrDefault(value, new LinkedList<LinkedList<Integer>>());
                LinkedList<Integer> seq = temp.peek();
                temp.pop();
                need.put(value, temp);
                // 对 value+ 1需求 加一
                LinkedList<LinkedList<Integer>> temp2 = need.getOrDefault(value + 1
                        , new LinkedList<LinkedList<Integer>>());
                seq.addLast(value + 1);
                temp2.add(seq);
                need.put(value + 1, temp2);
            } else if (freq.getOrDefault(value, 0) > 0 &&
                    freq.getOrDefault(value + 1, 0) > 0 &&
                    freq.getOrDefault(value + 2, 0) > 0) {
                //可以组成顺子
                freq.put(value, freq.get(value) - 1);
                freq.put(value + 1, freq.get(value + 1) - 1);
                freq.put(value + 2, freq.get(value + 2) - 1);
                //需求+1
                LinkedList<LinkedList<Integer>> temp = need.getOrDefault(value + 3, new LinkedList<LinkedList<Integer>>());
                LinkedList<Integer> t = new LinkedList<>();
                t.addLast(value);
                t.addLast(value + 1);
                t.addLast(value + 2);
                temp.add(t);
                need.put(value + 3, temp);
            } else {
                return false;
            }
        }

        for (Entry<Integer, LinkedList<LinkedList<Integer>>>  integerLinkedListEntry : need.entrySet()) {
            System.out.println(integerLinkedListEntry.getValue().toString());
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[]{1, 2, 3, 3, 4, 5}));
    }
}