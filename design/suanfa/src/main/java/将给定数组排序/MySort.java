import java.util.Arrays;

/**
 * @author zhengxin
 * @date 2021/3/18
 */
public class MySort {


    public static void main(String[] args) {
        int[] b = MySort(new int[]{213, 54, 5, 6, 7, 8, 43, 5, 76, 111});
        System.out.print(Arrays.toString(b));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public static int[] MySort(int[] arr) {
        // write code here
//        return maopao(arr);
        return kuaipai(arr);
    }


    /**
     * 冒泡
     */
    public static int[] maopao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int i1 = i + 1; i1 < arr.length; i1++) {
                if (arr[i] > arr[i1]) {
                    int temp = arr[i];
                    arr[i] = arr[i1];
                    arr[i1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 快排
     */
    public static int[] kuaipai(int[] arr) {
        quickSort(arr,0,arr.length -1);
        return arr;
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int ltemp = getLtemp(arr, left, right);

            quickSort(arr, left, ltemp);
            quickSort(arr, ltemp + 1, right);
        }
    }

    private static int getLtemp(int[] arr, int left, int right) {
        int ltemp = left;
        int rtemp = right;

        // f 分界值
        //以左边第1个为基数
        int f = arr[left];
        while(ltemp < rtemp){
            //右边找比分界值小的
            while (ltemp < rtemp && arr[rtemp] >= f){
                rtemp--;
            }
            arr[ltemp] = arr[rtemp];

            // 左边找到比分界值大的
            while (ltemp < rtemp && arr[ltemp] <= f) {
                ltemp++;
            }
            arr[rtemp] = arr[ltemp];
        }
        // f记录的是原来的arr[letf]的值。 所以上面的
        //   arr[ltemp] = arr[rtemp];
        //      arr[rtemp] = arr[ltemp]; 是交换
        arr[ltemp] = f;
        return ltemp;
    }

}
