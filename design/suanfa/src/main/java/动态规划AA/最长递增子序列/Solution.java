package 动态规划AA.最长递增子序列;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class Solution {

    /**
     * 对于第一步，有两种解法：
     * <p>
     * 动态规划，时间复杂度为O(n^2)，会超时
     * 贪心+二分，时间复杂度为O(nlogn)
     * 下面说说贪心+二分的解法，举例说明基本思路，假设数组arr为[2, 3, 1, 2, 3]，vec数组里面存放递增子序列，maxLen数组里存放以元素i结尾的最大递增子序列长度，那么遍历数组arr并执行如下更新规则:
     * <p>
     * 初始情况下，vec为[2]，maxLen[1]
     * 接下来遇到3，由于vec最后一个元素小于3，直接更新，vec为[2,3]，maxLen[1,2]
     * 接下来遇到1，由于vec最后的元素大于1, 我们在vec中查找大于等于1的第一个元素的下标，并用1替换之，此时vec为[1,3], maxLen[1,2,1]
     * 接下来遇到2，由于vec最后的元素大于2，我们在vec中查找大于等于2的第一个元素的下标，并用2替换之，此时vec为[1,2], maxLen[1,2,1,2]
     * 接下来遇到3，由于vec最后一个元素小于3，直接更新，vec为[1,2,3]，maxLen为[1,2,1,2,3]
     * 此时vec的大小就是整个序列中最长递增子序列的长度（但是vec不一定是本题的最终解）
     * <p>
     * <p>
     * 对于第二步，
     * <p>
     * 假设我们原始数组是arr1，
     * <p>
     * 得到的maxLen为[1,2,3,1,3]，
     * 最终输出结果为res（字典序最小的最长递增子序列），
     * res的最后一个元素在arr1中位置无庸置疑是maxLen[i]==3对应的下标，
     * 那么到底是arr1[2]还是arr1[4]呢？如果是arr1[2]，
     * 那么arr1[2]<arr1[4]，则maxLen[4]==4，与已知条件相悖。
     * 因此我们应该取arr1[4]放在res的最后一个位置。
     * <p>
     * 完整代码如下：
     *
     * @param arr
     * @return
     */
    public int[] LIS (int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(arr[0]);
        ArrayList<Integer> maxLens = new ArrayList<Integer>();
        maxLens.add(1);
        //贪心
        for (int i = 1; i < arr.length; i++) {
            //如果当前数组大于 res最大的
            int resLen = res.size();
            if (arr[i] >= res.get(resLen-1)) {
                res.add(arr[i]);
                maxLens.add(res.size());
            } else {
                //如果小于，则要找数组中比他大的，替换 , 2分
                int left = 0 , right = resLen - 1;
                // 记录下标
                int index = 0;
                while(left <= right){
                    // +1 保证边界落在right边
                    int mid = left + (right - left ) / 2;
                    if(res.get(mid) >= arr[i]){
                        index = mid;
                        right = mid-1;
                    }else{
                        left = mid + 1;
                    }
                }
                //替换下标值
                res.set(index, arr[i]);
                //index 是下标， 但是 maxlens记录是的长度
                maxLens.add(index + 1);
            }
        }

        // 从后往前找。 上面有解释原因 , 找到最小字典的
        // maxLens.get(i)  获取当前最大值的下标
        // j  是最大长度
        // 如果从后找到一个最大长度。 就替换。
        // 为什么 [1,2,3,1,3]   取的是 0 1 ， 4 呢？
        // maxLen 其实也记录了字典序 。 把小的往后排了。
        // 所以从后找下标跟 最大长度j 相等的就是最小字典序
        for (int i = maxLens.size() -1, j = res.size() ; j > 0; i--) {
            if (maxLens.get(i) == j) {
                //替换J值，
                res.set(--j, arr[i]);
            }
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().LIS(new int[]{2,1,3,5,6,4,8,9,7})));
    }
}