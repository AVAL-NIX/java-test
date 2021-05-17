package 数据结构集合AA.单调栈;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int一维数组
     * @return int二维数组
     */
    public int[][] foundMonotoneStack(int[] nums) {
        // write code here
        int[][] result = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            int iValue = nums[i];
            int[] temp = new int[2];
            //找左边
            for (int j = i-1; j >= 0; j--) {
                if(j > 0 && nums[j] < iValue){
                    temp[0] = j;
                    break;
                }else {
                    temp[0] = j;
                }
            }
            //找右边
            for (int k = i + 1; k < nums.length; k++) {
                if(k < nums.length && nums[k] < iValue){
                    temp[1] = k;
                    break;
                }else {
                    temp[1] = -1;
                }
            }
            result[i] = temp;
        }
        return result;
    }
}
