package 数组集合AA.旋转数组的最小数字;

class Solution {
    /**
     * 123456789
     * 789123456
     * 456789123
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left ) / 2;
            int v = numbers[mid];
            if( v > numbers[right]){
                left = mid + 1;
            }else if( v < numbers[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return numbers[left];
    }
}