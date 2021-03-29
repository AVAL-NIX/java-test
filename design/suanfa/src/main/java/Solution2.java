import java.util.ArrayList;

/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] b = {4, 5, 1, 6, 2, 7, 3, 8};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.GetLeastNumbers_Solution(b, 4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        if (input == null || input.length < k) {
            return result;
        }
        quick(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public void quick(int[] a, int left, int right) {
        if (left < right) {
            int f = getIndex(a, left, right);
            quick(a, left, f);
            quick(a, f + 1, right);
        }
    }


    public int getIndex(int[] arr, int left, int right) {
        int ltemp = left;
        int rtemp = right;

        int f = arr[left];
        while (ltemp < rtemp) {
            //右边找到比中间值大的
            while (ltemp < rtemp && arr[rtemp] >= f) {
                rtemp--;
            }
            arr[ltemp] = arr[rtemp];

            //左边边找到比中间值大的
            while (ltemp < rtemp && arr[ltemp] <= f) {
                ltemp++;
            }
            arr[rtemp] = arr[ltemp];
        }
        arr[ltemp] = f;
        return ltemp;
    }
}
