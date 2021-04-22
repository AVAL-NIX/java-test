package 缺失数字;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 时间复杂度：图片说明
     * 思路：因为 0-n 个数里面只缺少一个数，所以可以直接对 0-n 求和，然后再减去a 数组的和就是答案了。
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve(int[] a) {
        int aLen = a.length;
        int presum = aLen * (aLen + 1) / 2;
        int sum = 0;
        for (int i = 0; i < aLen; i++) {
            sum += a[i];
        }
        return presum - sum;
    }

    /**
     * 二分法
     * 这里的思路是
     *
     * 下标也是值， a[index] 一定等于 index
     * 如果中间缺失的话 。 a[index] > index 值了，值就一定会在左边。
     * 不断缩小左边范围，右边范围， 最后左边跟右边下标相等就是缺失的值
     *
     * @param a
     * @return
     */
    public int solve2(int[] a) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 如果相等 一定是在右边 。 。。 因为上面求出来是向下取整
            if (a[mid] == mid) {
                left = mid + 1;
            }else if(a[mid] > mid){
                right = mid - 1;
            }else if(a[mid] < mid){
                left = mid + 1;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12};
        System.out.println(new Solution().solve2(a));
    }
}
