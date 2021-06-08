package 滑动窗口集合AA.盛最多水的容器;

class Solution {
    public int maxArea(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int water = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right) {
            //确定左边的最高柱子
            leftmax = Math.max(arr[left], leftmax);
            //确定右边的最高柱子
            rightmax = Math.max(arr[right], rightmax);
            //计算
            if (arr[left] < arr[right]) {
                //桶的高度是leftmax
                water = Math.max(water, arr[left] * (right - left));
            } else {
                //桶的高度是rightmax
                water = Math.max(water, arr[right] * (right - left));
            }
            //移动指针
            if (leftmax > rightmax) {
                right--;
            } else {
                left++;
            }
        }
        return water;
    }

    public int dp(int[] arr, int left, int right) {
        if (left > right) {
            return 0;
        }
        int water = Math.max(dp(arr, left + 1, right), dp(arr, left, right - 1));
        getWater(arr, left, right);
        return water;
    }

    int water = 0;

    private int getWater(int[] arr, int left, int right) {
        //那么桶的高度就是leftmax和rightmax中最小的那个
        if (arr[left] < arr[right]) {
            //桶的高度是leftmax
            water = Math.max(water, arr[left] * (right - left));
        } else {
            //桶的高度是rightmax
            water = Math.max(water, arr[right] * (right - left));
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}