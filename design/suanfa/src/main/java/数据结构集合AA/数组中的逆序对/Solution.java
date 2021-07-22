package 数据结构集合AA.数组中的逆序对;

class Solution {

//    int[] nums, temp;
//
//    public int reversePairs(int[] nums) {
//        this.nums = nums;
//        this.temp = new int[nums.length];
//        return mergeSort(0, nums.length - 1);
//    }
//
//    private int mergeSort(int l, int r) {
//        //终止条件
//        if (l >= r) {
//            return 0;
//        }
//        //化分
//        int m = (l + r) / 2;
//        int res = mergeSort(l, m) + mergeSort(m + 1, r);
//        //合并
//        int i = l , j = r + 1;
//
//        //装到临时变量中
//        for (int k = l; k < r; k++) {
//            temp[k] = nums[k];
//        }
//
//        for (int k = l; k < r; k++) {
//            if (i == m + 1)
//                nums[k] = temp[j++];
//            else if (j == r + 1 || temp[i] <= temp[j])
//                nums[k] = temp[i++];
//            else {
//                nums[k] = temp[j++];
//                res += m - i + 1; // 统计逆序对
//            }
//        }
//
//        return res;
//    }


    int count;
    public int reversePairs(int[] nums) {
        this.count = 0;
        merge(nums, 0, nums.length - 1);
        return count;
    }

    public void merge(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }
    }

    public void mergeSort(int[] nums, int left, int mid, int right) {
        int[] temparr = new int[right - left + 1];
        int index = 0;
        int temp1 = left, temp2 = mid + 1;

        while (temp1 <= mid && temp2 <= right) {
            if (nums[temp1] <= nums[temp2]) {
                temparr[index++] = nums[temp1++];
            } else {
                //用来统计逆序对的个数
                count += (mid - temp1 + 1);
                temparr[index++] = nums[temp2++];
            }
        }
        //把左边剩余的数移入数组
        while (temp1 <= mid) {
            temparr[index++] = nums[temp1++];
        }
        //把右边剩余的数移入数组
        while (temp2 <= right) {
            temparr[index++] = nums[temp2++];
        }
        //把新数组中的数覆盖nums数组
        for (int k = 0; k < temparr.length; k++) {
            nums[k + left] = temparr[k];
        }
    }

    public static void main(String[] args) {
        System.out.println(new int[]{9,84,4,2});
    }
}