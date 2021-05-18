package 查找算法集合AA.在D天内送达包裹的能力;


/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = getMax(weights, days);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isOk(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isOk(int[] weights, int mid, int days) {
        int minDays = 1;
        int tempMid = mid;
        for (int i = 0; i < weights.length; i++) {
            int tempVal = weights[i];
            if (tempMid - tempVal >= 0) {
                //继续循环
                tempMid -= tempVal;
            } else {
                minDays++;
                tempMid = mid;
                //这次不够的还要减
                tempMid -= tempVal;
                //如果小于0直接返回false
                if (tempMid < 0) {
                    return false;
                }
            }
        }
        if (minDays <= days) {
            return true;
        }
        return false;
    }

    private int getMax(int[] weights, int day) {
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
//            if(weights[i] > max){
//                max = weights[i];
//            }
                max += weights[i];
        }
//        return max  * weights.length;
        return max ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shipWithinDays(new int[]{
                70,259,379,369,287,145,259,29,150,410,493,121,184,92,79,168,269,209,139,437
    }, 20));
    }
}
