package 查找算法集合AA.在排序数组中查找数字1;

class Solution {
    public int search(int[] nums, int target) {
        int left =0 , right = nums.length-1 ;
        int count = 0;
        while(left <= right){
            int mid = left + ( right - left) / 2;
            int v = nums[mid];
            if(v == target){
                //统计个数
                count++;
                //往前 mid
                int pre = mid - 1 ;
                while(pre >= 0 && nums[pre] == v){
                    pre--;
                    count++;
                }
                int after = mid + 1;
                while(after < nums.length && nums[after] == v){
                    after++;
                    count++;
                }
                return count;
            }else if(v < target){
                left = mid + 1;
            }else if ( v > target){
                right = mid - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(3<<1);
//        System.out.println(new Solution().search(new int[]{5,7,7,8,8,10}, 8));
    }
}