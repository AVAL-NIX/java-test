package 查找算法集合AA.数字在升序数组中出现的次数;

/**
 * 牛牛有一个n个数字的序列a_1,a_2,\dots,a_na
 * 1
 * ​
 *  ,a
 * 2
 * ​
 *  ,…,a
 * n
 * ​
 *  ，现在牛牛想把这个序列分成k段连续段，牛牛想知道分出来的k个连续段的段内数字和的最小值最大可以是多少？
 */
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int count = 0 ;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                count++;
                if(mid < array.length ){
                    int tempMid = mid +1;
                    while (tempMid < array.length){
                        if(array[tempMid] == k){
                            count++;
                        }else{
                            break;
                        }
                        tempMid++;
                    }
                }
                if(mid > 0){
                    int tempMid = mid -1;
                    while (tempMid >=0){
                        if(array[tempMid] == k){
                            count++;
                        }else{
                            break;
                        }
                        tempMid--;
                    }
                }
                return count;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k){
                right = mid - 1;
            }
        }
        return count;
    }
}
