package week.统计定界子数组的数目;

import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left = 0, right = 0;
        int result = 0;
        SingleQueue hashSet = new SingleQueue();
        hashSet.push(nums[left], left);
        while (left < nums.length) {
//            for (int i = left; i <= right; i++) {
//                hashSet.push(nums[i]);
//            }
            if (isMinMax(hashSet, minK, maxK)) {
                result++;
            }
            //都不存在 跳过
//            if (isMinMax2(hashSet, minK, maxK)) {
//                left = right + 1;
//                right = right + 1;
//                continue;
//            }
            //移动窗口
            // 左边滑动的条件
//            if (left < right && isMinMax(hashSet, minK, maxK) && (left - 1 >= 0 && isExits(nums, minK, maxK, left + 1, right))) {
//                left++;
//                continue;
//            } else {
//                right++;
//                continue;
//            }

            // 判断是否跳过
            if (isMinMax2(hashSet, minK, maxK)) {
                right = nums.length;
            } else {
                right++;
            }

            if (right == nums.length) {
                left = hashSet.getIndex() + 1;
                right = left;
                hashSet = new SingleQueue();
                if (left < nums.length)
                    hashSet.push(nums[left], left);
            } else {
                hashSet.push(nums[right], right);
            }
        }
        return result;
    }


    public boolean isMinMax(SingleQueue values, int minK, int maxK) {
        if (values.max() == maxK && values.min() == minK) {
            return true;
        }
        return false;
    }

    public boolean isMinMax2(SingleQueue values, int minK, int maxK) {
        if (values.min() < minK || maxK < values.max()) {
            return true;
        }
        return false;
    }


    public class SingleQueue {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int maxIndex = -1;

        public void push(int n, int index) {
            if (n > max) {
                max = n;
                maxIndex = index;
            }
            if (n < min) {
                min = n;
                minIndex = index;
            }
        }

        public int max() {
            return max;
        }

        public int getMaxIndex() {
            return maxIndex;
        }

        public int getMinIndex() {
            return minIndex;
        }

        public int getIndex() {
            return minIndex < maxIndex ? minIndex : maxIndex;
        }

        public int min() {
            return min;
        }

    }


    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println(new Solution().countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));
    }
}