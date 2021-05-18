package 查找算法集合AA.分割数组的最大值;

class Solution {
    public int splitArray(int[] nums, int m) {
        int left = getMax(nums), right = getSum(nums);
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 根据分割子数组的个数收缩搜索区间
            int n = split(nums, mid);
            if (n == m) {
                right = mid;
            } else if (n < m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 如果限制数组和为mid  ， 能分成几个函数？
     *
     * @param nums
     * @param mid  数组最大和
     * @return
     */
    private int split(int[] nums, int mid) {
        int count = 1;
        int tempSum = mid;
        for (int i = 0; i < nums.length; i++) {
            if (tempSum - nums[i] >= 0) {
                tempSum -= nums[i];
            }else{
                //如果不能减了 。 。。
                count++;
                tempSum = mid;
                tempSum -= nums[i];
            }
        }
        return count;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
