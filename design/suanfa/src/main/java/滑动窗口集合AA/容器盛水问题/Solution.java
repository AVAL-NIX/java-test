package 滑动窗口集合AA.容器盛水问题;

/**
 * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
 *
 * @author zhengxin
 * @date 2021/4/8
 */
public class Solution {
    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {
        // write code here
//        if (arr.length <= 2) {
//            return 0;
//        }
//        long water = 0;
//        int left = 0, right = arr.length - 1;
//        //最开始的时候确定left和right的边界，这里的left和right是
//        //柱子的下标，不是柱子的高度
//        while (left < right && arr[left] <= arr[left + 1]){
//            left++;
//        }
//        while (left < right && arr[right] <= arr[right - 1]){
//            right--;
//        }
//
//        while (left < right) {
//            int leftValue = arr[left];
//            int rightValue = arr[right];
//            //在left和right两根柱子之间计算盛水量
//            if (leftValue <= rightValue) {
//                //如果左边柱子高度小于等于右边柱子的高度，根据木桶原理，
//                // 桶的高度就是左边柱子的高度
//                while (left < right && leftValue >= arr[++left]) {
//                    water += leftValue - arr[left];
//                }
//            } else {
//                //如果左边柱子高度大于右边柱子的高度，根据木桶原理，
//                // 桶的高度就是右边柱子的高度
//                while (left < right && arr[--right] <= rightValue) {
//                    water += rightValue - arr[right];
//                }
//            }
//        }
//        return water;

        int left = 0;
        int right = arr.length - 1;
        long water = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right) {
            //确定左边的最高柱子
            leftmax = Math.max(leftmax, arr[left]);
            //确定左边的最高柱子
            rightmax = Math.max(rightmax, arr[right]);
            //那么桶的高度就是leftmax和rightmax中最小的那个
            if (leftmax < rightmax) {
                //桶的高度是leftmax
                water += (leftmax - arr[left++]);
            } else {
                //桶的高度是rightmax
                water += (rightmax - arr[right--]);
            }
        }
        return water;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxWater(new int[]{3, 1, 2, 5, 2, 4}));
    }
}

