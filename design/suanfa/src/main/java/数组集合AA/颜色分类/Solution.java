package 数组集合AA.颜色分类;

class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2=0;
        int right = nums.length-1;
        int left = 0 ;
        for(int i= 0 ; i < right; i++){
            int v = nums[i];
            if(v == 0){
                swap(nums, left, i);
                left++;
            }else if(v == 2){
                swap(nums, right, i);
                right--;
                i--;
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        new Solution().sortColors(new int[]{2,0,1});
    }
}